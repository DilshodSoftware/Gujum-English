package com.example.gujumenglish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.gujumenglish.ui.cardlesson.CardLessonScreen
import com.example.gujumenglish.ui.theme.GujumEnglishTheme

class CardLessonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideAppSystemBars()
        setContent {
            GujumEnglishTheme {
                CardLessonScreen(
                    onBack = { finish() },
                    modifier = Modifier
                )
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideAppSystemBars()
        }
    }
}
