package com.example.gujumenglish

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Space
import androidx.activity.ComponentActivity

class GrammarLessonActivity : ComponentActivity() {
    private var lessonWebView: WebView? = null
    private var lessonToolbar: LinearLayout? = null
    private var lessonRoot: LinearLayout? = null
    private var fontSizePercent = DEFAULT_FONT_SIZE_PERCENT

    override fun onCreate(savedInstanceState: Bundle?) {
        hideAppSystemBars()
        super.onCreate(savedInstanceState)
        hideAppSystemBars()

        val assetName = intent.getStringExtra(EXTRA_ASSET_NAME) ?: DEFAULT_ASSET_NAME
        val lessonTitle = intent.getStringExtra(EXTRA_LESSON_TITLE)
        fontSizePercent = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
            .getInt(FONT_SIZE_KEY, DEFAULT_FONT_SIZE_PERCENT)
        if (!lessonTitle.isNullOrBlank()) {
            title = lessonTitle
        }

        val webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.allowFileAccess = true
            settings.allowContentAccess = true
            settings.textZoom = fontSizePercent
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String?) {
                    super.onPageFinished(view, url)
                    view.evaluateJavascript(
                        "(function(){return getComputedStyle(document.body).backgroundColor;})()"
                    ) { rawColor ->
                        applyLessonBackground(rawColor)
                    }
                }
            }
            loadUrl("file:///android_asset/grammar/$assetName")
        }
        lessonWebView = webView

        val lessonBackgroundColor = Color.rgb(244, 247, 252)
        val density = resources.displayMetrics.density
        val toolbarInset = (12 * density).toInt()
        val toolbarSize = (56 * density).toInt()
        val fontButtonWidth = (52 * density).toInt()
        val fontButtonGap = (4 * density).toInt()
        val backButton = ImageButton(this).apply {
            setImageResource(R.drawable.ic_arrow_back_practice)
            contentDescription = "Orqaga qaytish"
            setBackgroundColor(Color.TRANSPARENT)
            setPadding(16, 16, 16, 16)
            setOnClickListener { finish() }
        }
        val fontDecreaseButton = createFontButton(
            label = "A-",
            description = "Shriftni kichraytirish",
            delta = -FONT_SIZE_STEP
        )
        val fontIncreaseButton = createFontButton(
            label = "A+",
            description = "Shriftni kattalashtirish",
            delta = FONT_SIZE_STEP
        )
        val toolbar = LinearLayout(this).apply {
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(lessonBackgroundColor)
            setPadding(toolbarInset, 0, toolbarInset, 0)
            addView(
                backButton,
                LinearLayout.LayoutParams(toolbarSize, toolbarSize)
            )
            addView(
                Space(this@GrammarLessonActivity),
                LinearLayout.LayoutParams(0, toolbarSize, 1f)
            )
            addView(
                fontDecreaseButton,
                LinearLayout.LayoutParams(
                    fontButtonWidth,
                    toolbarSize
                ).apply { rightMargin = fontButtonGap }
            )
            addView(
                fontIncreaseButton,
                LinearLayout.LayoutParams(
                    fontButtonWidth,
                    toolbarSize
                )
            )
        }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(lessonBackgroundColor)
            addView(
                toolbar,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            addView(
                webView,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    0,
                    1f
                )
            )
        }
        lessonToolbar = toolbar
        lessonRoot = root
        setContentView(root)
    }

    private fun createFontButton(
        label: String,
        description: String,
        delta: Int
    ): Button =
        Button(this).apply {
            text = label
            textSize = 17f
            isAllCaps = false
            minWidth = 0
            minimumWidth = 0
            setPadding(0, 0, 0, 0)
            contentDescription = description
            setOnClickListener { changeFontSize(delta) }
        }

    private fun applyLessonBackground(rawCssColor: String) {
        val cssColor = rawCssColor.trim().trim('"')
        if (cssColor == "transparent" || cssColor == "rgba(0, 0, 0, 0)") {
            return
        }
        val parsedColor = runCatching {
            when {
                cssColor.startsWith("#") -> Color.parseColor(cssColor)
                else -> {
                    val match = Regex(
                        "rgba?\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)"
                    ).find(cssColor) ?: return
                    Color.rgb(
                        match.groupValues[1].toInt(),
                        match.groupValues[2].toInt(),
                        match.groupValues[3].toInt()
                    )
                }
            }
        }.getOrNull() ?: return
        lessonToolbar?.setBackgroundColor(parsedColor)
        lessonRoot?.setBackgroundColor(parsedColor)
    }

    private fun changeFontSize(delta: Int) {
        fontSizePercent = (fontSizePercent + delta)
            .coerceIn(MIN_FONT_SIZE_PERCENT, MAX_FONT_SIZE_PERCENT)
        lessonWebView?.settings?.textZoom = fontSizePercent
        getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
            .edit()
            .putInt(FONT_SIZE_KEY, fontSizePercent)
            .apply()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideAppSystemBars()
        }
    }

    override fun onDestroy() {
        lessonWebView?.apply {
            stopLoading()
            destroy()
        }
        lessonWebView = null
        lessonToolbar = null
        lessonRoot = null
        super.onDestroy()
    }

    companion object {
        const val EXTRA_ASSET_NAME = "grammar_asset_name"
        const val EXTRA_LESSON_TITLE = "grammar_lesson_title"
        private const val DEFAULT_ASSET_NAME = "UnitAllLessons/unit_0/1_Dictionary.html"
        private const val PREFERENCES_NAME = "grammar_preferences"
        private const val FONT_SIZE_KEY = "font_size_percent"
        private const val DEFAULT_FONT_SIZE_PERCENT = 100
        private const val MIN_FONT_SIZE_PERCENT = 50
        private const val MAX_FONT_SIZE_PERCENT = 150
        private const val FONT_SIZE_STEP = 10
    }
}
