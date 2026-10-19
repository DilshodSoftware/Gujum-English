package com.example.gujumenglish.data.local

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlin.math.roundToInt
import kotlin.random.Random

/**
 * Card-based learning: FSRS scheduling, daily queue, comeback mode, settings.
 *
 * Scheduling is per-card by REAL calendar time, never by "app day number".
 * Missed days don't break anything: cards simply become overdue (lower R).
 */
class CardLearningService(private val context: Context) {

    private val database: CardDatabase by lazy { CardDatabase.getInstance(context) }
    private val dao: CardDao by lazy { database.cardDao() }
    private val prefs by lazy {
        context.getSharedPreferences("card_prefs", Context.MODE_PRIVATE)
    }

    companion object {
        const val DEFAULT_RETENTION = 0.90f
        const val DEFAULT_DAILY_CAP = 20
        const val COMEBACK_THRESHOLD_DAYS = 14L
        const val DIAGNOSTIC_PER_LESSON = 2
        const val DAY_MS = 24L * 60 * 60 * 1000
    }

    // ---------- settings ----------

    /** Desired retention is fixed at 90% (FSRS research optimum). */
    fun getDesiredRetention(): Float = DEFAULT_RETENTION

    fun getDailyCap(): Int =
        prefs.getInt("daily_cap", DEFAULT_DAILY_CAP).coerceIn(20, 100)

    fun setDailyCap(value: Int) {
        prefs.edit().putInt("daily_cap", value.coerceIn(20, 100)).apply()
    }

    fun getLastActive(): Long = prefs.getLong("last_active_ms", 0L)

    private fun touchActive(now: Long) {
        prefs.edit().putLong("last_active_ms", now).apply()
    }

    // ---------- import / flows ----------

    suspend fun initializeCards() {
        CardContentImporter.importIfEmpty(context, database)
    }

    fun getCardsForLesson(lessonId: Int): Flow<List<CardEntity>> = dao.getCardsByLesson(lessonId)

    fun getAllCards(): Flow<List<CardEntity>> = dao.getAllCards()

    suspend fun getDueCards(userId: Int = 1, now: Long = System.currentTimeMillis()): List<CardUserState> {
        return dao.getDueCards(userId, now)
    }

    // ---------- daily queue ----------

    data class QueueResult(
        val cards: List<CardEntity>,
        val dueCount: Int,
        val newCount: Int,
        val isComeback: Boolean,
        val overdueDays: Long
    )

    /**
     * Daily queue: overdue first (lowest R), then new cards, interleaved by
     * type, capped. Comeback mode (14+ days away): short diagnostic test
     * with 1-2 cards per lesson instead of the full backlog.
     */
    suspend fun buildDailyQueue(
        userId: Int = 1,
        now: Long = System.currentTimeMillis()
    ): QueueResult {
        val cap = getDailyCap()
        val retention = getDesiredRetention().toDouble()
        val all = dao.getAllCardsOnce()
        if (all.isEmpty()) return QueueResult(emptyList(), 0, 0, false, 0)
        val states = dao.getActiveUserStates(userId).associateBy { it.cardId }

        val lastActive = getLastActive()
        val awayDays = if (lastActive <= 0L) 0L else (now - lastActive) / DAY_MS
        if (awayDays >= COMEBACK_THRESHOLD_DAYS) {
            // Diagnostic: up to N cards per lesson, prefer least-practiced.
            val diag = all.groupBy { it.lessonId }
                .toSortedMap()
                .flatMap { (_, lessonCards) ->
                    lessonCards.sortedBy { states[it.id]?.reps ?: 0 }
                        .take(DIAGNOSTIC_PER_LESSON)
                }
                .take(cap)
            return QueueResult(
                cards = diag,
                dueCount = 0,
                newCount = diag.size,
                isComeback = true,
                overdueDays = awayDays
            )
        }

        // Due cards with retrievability, lowest R first.
        val dueRanked = states.values
            .filter { it.due != null && it.due <= now && it.stability != null }
            .map { st ->
                val elapsed = ((now - (st.lastReview ?: now)).coerceAtLeast(0L))
                    .toDouble() / DAY_MS
                val r = FsrsScheduler.retrievability(elapsed, st.stability!!)
                st to r
            }
            .sortedBy { it.second }
        val dueCards = dueRanked.take(cap).mapNotNull { (st, _) ->
            all.find { it.id == st.cardId }
        }

        // New cards (no state row yet) fill the rest of the cap.
        val remaining = (cap - dueCards.size).coerceAtLeast(0)
        val newCards = all.filter { !states.containsKey(it.id) }.take(remaining)

        val queue = interleaveByType(dueCards + newCards)
        return QueueResult(
            cards = queue,
            dueCount = dueCards.size,
            newCount = newCards.size,
            isComeback = false,
            overdueDays = 0
        )
    }

    /** Round-robin by card type so a session mixes types (interleaving). */
    private fun interleaveByType(cards: List<CardEntity>): List<CardEntity> {
        if (cards.size <= 1) return cards
        val buckets = cards.groupBy { it.type }.values.map { it.toMutableList() }
        val out = ArrayList<CardEntity>(cards.size)
        var added = true
        while (added) {
            added = false
            for (b in buckets) {
                if (b.isNotEmpty()) {
                    out.add(b.removeAt(0))
                    added = true
                }
            }
        }
        return out
    }

    // ---------- review ----------

    suspend fun submitReview(
        userId: Int = 1,
        cardId: String,
        grade: Int,
        now: Long = System.currentTimeMillis(),
        responseTimeMs: Long
    ) {
        val g = grade.coerceIn(1, 4)
        val prevState = dao.getUserState(userId, cardId)
        val elapsedDays = if (prevState?.lastReview == null) {
            0.0
        } else {
            ((now - prevState.lastReview).coerceAtLeast(0L)).toDouble() / DAY_MS
        }

        val log = ReviewLog(
            userId = userId,
            cardId = cardId,
            grade = g,
            reviewedAt = now,
            elapsedDays = elapsedDays.roundToInt(),
            responseTimeMs = responseTimeMs,
            prevStability = prevState?.stability,
            prevDifficulty = prevState?.difficulty
        )
        dao.insertReviewLog(log)

        val res = FsrsScheduler.schedule(
            prevStability = prevState?.stability,
            prevDifficulty = prevState?.difficulty?.toDouble(),
            elapsedDays = elapsedDays,
            grade = g,
            desiredRetention = getDesiredRetention().toDouble()
        )

        val due = if (res.intervalDays <= 0) {
            // Lapse: back soon the same day.
            now + FsrsScheduler.LAPSE_DELAY_MINUTES * 60 * 1000
        } else {
            // ±5% fuzz so cards don't pile onto the same day.
            val jitter = 1.0 + (Random.nextDouble() - 0.5) * 0.10
            val days = (res.intervalDays * jitter).roundToInt().coerceAtLeast(1)
            now + days * DAY_MS
        }

        val updatedState = (prevState ?: CardUserState(userId = userId, cardId = cardId))
            .copy(
                state = if (g == 1) "relearning" else "review",
                stability = res.stability,
                difficulty = res.difficulty.roundToInt().coerceIn(1, 10),
                due = due,
                lastReview = now,
                reps = (prevState?.reps ?: 0) + 1,
                lapses = if (g == 1) (prevState?.lapses ?: 0) + 1 else (prevState?.lapses ?: 0)
            )
        if (prevState == null) dao.insertUserState(updatedState)
        else dao.updateUserState(updatedState)
        touchActive(now)
    }
}
