# GujumEnglish

O'zbek tilida so'zlashuvchilar uchun ingliz tili o'rganish Android ilovasi:
grammatika darslari, interaktiv testlar, audio talaffuz va gapirish mashqlari.

## Imkoniyatlar

- **Grammar** — 8 ta unit, 66 ta dars (nazariya HTML + amaliyot HTML).
  Har bir darsda inglizcha matn yonida 🔊 audio tugma.
- **Testlar** — 1–4-darslar uchun interaktiv test
  (`1-test. Bilimingizni sinang`): tanlash, moslash, yozish, gap tuzish.
- **Practice** — gaplarni tinglash, takrorlash va baholash (STT).
- **Statistics** — o'rganilgan gaplar hisobi.
- Shrift o'lchami (50–150%) dars va testda umumiy saqlanadi.

## Texnologiyalar

Kotlin, Jetpack Compose, WebView (darslar), Room (lug'at),
Coil (rasmlar), Moonshine STT, Piper TTS.

## Loyiha tuzilishi

```
app/src/main/
├── java/com/example/gujumenglish/
│   ├── MainActivity.kt                  # pastki navigatsiya: Grammar / Practice / Statistics
│   ├── GrammarLessonActivity.kt         # dars HTML + A-/A+ shrift
│   ├── GrammarPracticeActivity.kt       # interaktiv test ekrani
│   ├── ui/grammar/
│   │   ├── GrammarScreen.kt             # 8 unit, 66 dars ro'yxati + asset yo'llar
│   │   ├── SoftGrammarScreen.kt         # ro'yxat UI
│   │   └── practice/                    # Lesson1..4Questions.kt, savol turlari, registr
│   ├── ui/practice/ ui/list/            # gap mashqlari ro'yxati
│   ├── ui/statistics/                   # statistika ekrani
│   ├── audio/ image/ data/local/        # audio, rasm, Room lug'at
│   └── MoonshineTinyEngine.kt           # nutqni matnga o'girish
└── assets/
    ├── grammar/UnitAllLessons/unit_0..unit_7/  # 66 dars + 66 amaliyot HTML
    │   └── unit_0/unit_0_dictionary_opus/      # lug'at audiolari (.opus)
    ├── audio/ images/ stt/ dictionary.db
```

## Yangi dars testi qo'shish

1. `ui/grammar/practice/Lesson<N>Questions.kt` yozing.
2. `GrammarQuizRegistry.kt` dagi `lessonQuestionBanks` ga `N to { lesson<N>Questions }` qo'shing.
3. `GrammarScreen.kt` da shu dars guruhiga
   `GrammarTopic("N.3", "N-test. Bilimingizni sinang", "<amaliyot html>", testLesson = N)`
   qatorini qo'shing.

## Ishga tushirish

1. Loyihani Android Studio da oching.
2. `local.properties` da `sdk.dir` to'g'ri ko'rsatilganini tekshiring.
3. **Run ▶** (minSdk 26).

## Eslatmalar

- `build/`, `.gradle/`, `local.properties` gitga kirmaydi.
- Dars HTML dagi ranglar bir xil palitrada (`#174a6b`, `#2e7ea3`,
  `#eef6fe`, fon `#f5f7fa`) — yangi sahifa qo'shganda shuni saqlang.
