package com.example.gujumenglish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.example.gujumenglish.ui.cardlesson.CardLessonScreen
import com.example.gujumenglish.ui.theme.GujumEnglishTheme

class CardLessonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GujumEnglishTheme {
                CardLessonScreen(
                    onBack = { finish() },
                    modifier = Modifier
                )
            }
        }
    }
}
