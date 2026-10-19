package com.example.gujumenglish.data.local

import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * FSRS-6 scheduler (pure Kotlin, no dependencies).
 *
 * Latest official defaults (21 parameters, open-spaced-repetition wiki).
 * Do NOT hand-tune the math: weights w0..w20 are published defaults trained
 * on large real review datasets. Once ~1000+ review logs exist in
 * [ReviewLog], weights can be optimized (log-loss) globally first,
 * per-user later.
 *
 * Grades: 1=Again, 2=Hard, 3=Good, 4=Easy.
 */
object FsrsScheduler {

    /** Official FSRS-6 default weights (w0..w20). */
    val W = doubleArrayOf(
        0.212, 1.2931, 2.3065, 8.2956, 6.4133, 0.8334, 3.0194, 0.001,
        1.8722, 0.1666, 0.796, 1.4835, 0.0614, 0.2629, 1.6483, 0.6014,
        1.8729, 0.5425, 0.0912, 0.0658, 0.1542
    )

    /** Trainable decay (FSRS-6): R(S,S) = 90% by construction. */
    val DECAY: Double = -W[20]
    /** Chosen so that R(t=S) = 0.9 exactly. */
    val FACTOR: Double = 0.9.pow(-1.0 / W[20]) - 1.0
    const val MAX_INTERVAL_DAYS = 36500
    const val LAPSE_DELAY_MINUTES = 10L

    data class SchedResult(
        val stability: Double,
        val difficulty: Double,
        /** Whole days until next review (0 = same day lapse). */
        val intervalDays: Int,
        /** Retrievability at review time. */
        val retrievability: Double
    )

    /** R(t,S): probability of recall t days after review with stability S. */
    fun retrievability(elapsedDays: Double, stability: Double): Double {
        if (stability <= 0.0 || elapsedDays < 0.0) return 0.0
        return (1.0 + FACTOR * elapsedDays / stability).pow(DECAY)
    }

    fun initStability(grade: Int): Double = W[(grade - 1).coerceIn(0, 3)]

    fun initDifficulty(grade: Int): Double =
        (W[4] - exp(W[5] * (grade - 1)) + 1.0).coerceIn(1.0, 10.0)

    fun nextDifficulty(difficulty: Double, grade: Int): Double {
        val delta = -W[6] * (grade - 3)
        val next = difficulty + delta * (10.0 - difficulty) / 9.0
        return (W[7] * initDifficulty(4) + (1.0 - W[7]) * next).coerceIn(1.0, 10.0)
    }

    fun nextRecallStability(difficulty: Double, stability: Double, r: Double, grade: Int): Double {
        val inc = exp(W[8]) * (11.0 - difficulty) * stability.pow(-W[9]) *
                (exp((1.0 - r) * W[10]) - 1.0)
        val gradeWeight = when (grade) {
            2 -> W[15] // Hard penalty
            4 -> W[16] // Easy bonus
            else -> 1.0
        }
        return (stability * (1.0 + inc * gradeWeight)).coerceAtLeast(0.1)
    }

    fun nextForgetStability(difficulty: Double, stability: Double, r: Double): Double {
        return (W[11] * difficulty.pow(-W[12]) * ((stability + 1.0).pow(W[13]) - 1.0) *
                exp(W[14] * (1.0 - r))).coerceAtLeast(0.1)
    }

    /** Same-day repeat (FSRS-6: converges for large S; SInc >= 1 when G >= 2). */
    fun nextShortTermStability(stability: Double, grade: Int): Double {
        val s = (stability * exp(W[17] * (grade - 3 + W[18])) *
                stability.pow(-W[19])).coerceAtLeast(0.1)
        return if (grade >= 2) s.coerceAtLeast(stability) else s
    }

    /** Whole days for stability S at desired retention r. Minimum 1. */
    fun nextInterval(desiredRetention: Double, stability: Double): Int {
        val r = desiredRetention.coerceIn(0.80, 0.99)
        return (stability / FACTOR * (r.pow(1.0 / DECAY) - 1.0))
            .coerceIn(1.0, MAX_INTERVAL_DAYS.toDouble()).roundToInt()
    }

    /**
     * Full scheduling step.
     * @param prevStability null on first review
     * @param elapsedDays real elapsed days since last review (0 on first review)
     */
    fun schedule(
        prevStability: Double?,
        prevDifficulty: Double?,
        elapsedDays: Double,
        grade: Int,
        desiredRetention: Double
    ): SchedResult {
        val g = grade.coerceIn(1, 4)
        if (prevStability == null) {
            val s = initStability(g)
            val d = initDifficulty(g)
            val interval = if (g == 1) 0 else nextInterval(desiredRetention, s)
            return SchedResult(s, d, interval, 1.0)
        }
        val r = retrievability(elapsedDays, prevStability)
        val d = nextDifficulty(prevDifficulty ?: 5.0, g)
        if (g == 1) {
            val s = nextForgetStability(d, prevStability, r)
            return SchedResult(s, d, 0, r)
        }
        val s = if (elapsedDays < 1.0) {
            nextShortTermStability(prevStability, g)
        } else {
            nextRecallStability(d, prevStability, r, g)
        }
        return SchedResult(s, d, nextInterval(desiredRetention, s), r)
    }
}
