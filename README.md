# GujumEnglish

O'zbek tilida so'zlashuvchilar uchun ingliz tili o'rganish Android ilovasi.
To'liq **offline** ishlaydi: audio, rasmlar, tarjimalar va gapirishni
tekshirish (STT) — hammasi qurilmada, internet talab qilinmaydi.

## Imkoniyatlar

### Grammar (9 ta unit: UNIT 0–8, 67 ta dars)
- Har bir dars: **nazariya HTML** + **amaliyot HTML** + **interaktiv test**.
- 67 ta test `N-test. Bilimingizni sinang` nomi bilan mavjud.
- Dars matni o'ngida 🔊 audio tugma, A−/A+ shrift boshqaruvi.
- Test savol turlari: tanlash, ko'p tanlash, to'g'ri/noto'g'ri, yozish,
  moslash, gap tuzish (`TextMode`: UPPER/LOWER/ORDER/SPELLING/SENTENCE).
- Shrift o'lchami (50–150%) dars va testda umumiy saqlanadi.

### Practice (gap bo'yicha mashq)
- 1137 ta gap, har birida inglizcha matn, o'zbekcha tarjima, rasm (AVIF) va
  audio (0.80x tezlikda).
- 3 bosqichli sessiya: **o'rganish → gapirish (STT) → test**.
- Gapirish bosqichida mikrofon orqali yozib, o'z ovozingizni eshitib
  solishtirasiz.
- Sessiya hajmi: 1, 3, 6 yoki 9 ta gap.

### Card Lesson (FSRS bilan oraliqli takrorlash)
- **FSRS-6** algoritmi (rasmiy 21 ta default weight, o'rgatiladigan decay).
- 205 ta karta: 156 **grammar** (to'be-verb, a/an, can/can't, in/on/at
  bo'shliqlari) + 49 **rule** (unit_0 darslaridan qoidalar).
- 4 baho: Eslolmadim (qizil) · Qiynalib esladim (sariq) · Esladim (ko'k) ·
  Darrov esladim (yashil).
- Kunlik navbat: muddati o'tganlar birinchi (R eng pastdan), yangilar
  limitdan keyin. Limit 20–100, qadam 10.
- **Comeback rejimi**: 14+ kun kirmagan bo'lsa, to'liq backlogni emas,
  har darsdan 1–2 kartalik diagnostik testni ko'rsatadi.
- Har javob `review_logs` ga yoziladi — kelajakda w parametrlarini
  optimallashtirish uchun.

### Statistics
- O'rganilgan / qolgan gaplar soni, progress halqasi.
- O'rganilgan va o'rganilmagan gaplar ro'yxati.

## Texnologiyalar

| | |
|---|---|
| Til / UI | Kotlin 2.2.10, Jetpack Compose (Material 3) |
| Build | AGP 9.3.1, KSP, minSdk 26 / targetSdk 37 |
| Ma'lumot | Room 2.8.4 (dictionary.db, cards.db) + Paging 3.5.1 |
| Rasmlar | Coil 3 + avif-coder (768×576, q72) |
| Audio | MediaPlayer, `.opus` (0.70 / 0.80 / 0.95) |
| STT | sherpa-onnx + Moonshine v2 Tiny (43 MB, on-device) |
| Darslar | WebView (HTML asset) |

## Loyiha tuzilishi

```
app/src/main/
├── java/com/example/gujumenglish/
│   ├── MainActivity.kt                  # pastki navigatsiya: Grammar / Practice / Statistics
│   ├── GrammarLessonActivity.kt         # dars HTML + A-/A+ shrift
│   ├── GrammarPracticeActivity.kt       # test ekranini Compose da ochadi
│   ├── CardLessonActivity.kt            # FSRS card mashqi
│   ├── MoonshineTinyEngine.kt           # on-device nutqni matnga o'girish
│   ├── SystemBars.kt                    # immersive status/nav bar
│   ├── ui/
│   │   ├── LearningViewModel.kt         # practice sessiya holati
│   │   ├── grammar/
│   │   │   ├── GrammarScreen.kt         # 9 unit, 202 ta mavzu + asset yo'llari
│   │   │   ├── SoftGrammarScreen.kt     # ro'yxat UI
│   │   │   └── practice/
│   │   │   ├── GrammarQuizQuestion.kt    # savol turlari, normalizeAnswer
│   │   │   ├── GrammarQuizRegistry.kt    # dars -> savollar xaritasi
│   │   │   ├── GrammarPracticeScreen.kt  # test ekrani (Compose)
│   │   │   ├── PracticeColors.kt        # test ekrani palitrasi
│   │   │   └── Lesson1..67Questions.kt   # har darsning savollari
│   │   ├── practice/SentencePracticeScreen.kt # o'rganish/gapirish/test bosqichlari
│   │   ├── list/SentenceList.kt
│   │   ├── statistics/StatisticsScreen.kt
│   │   ├── cardlesson/CardLessonScreen.kt    # FSRS-6 kartalar oqimi
│   │   ├── navigation/MainNavigation.kt
│   │   └── theme/
│   ├── audio/    # SentenceAudioPlayer, SentenceAudioStorage, InMemoryAudioPlayer
│   ├── image/    # SentenceImageStorage, ImagePackInstaller
│   └── data/
│       ├── LearningRepository.kt
│       └── local/
│           ├── DictionaryDatabase.kt    # dictionary.db (1137 gap)
│           ├── CardDatabase.kt          # cards.db (v6: cards/user_cards/review_logs)
│           ├── FsrsScheduler.kt          # FSRS-6 formulalari
│           └── CardLearningService.kt   # kunlik navbat, comeback, review
└── assets/
    ├── grammar/UnitAllLessons/unit_0..unit_8/   # 134 HTML (67 dars + 67 amaliyot)
    │   └── unit_N/unit_N_dictionary_txt/         # gap matnlari (EN|UZ)
    ├── audio/    # 1451 opus (s001_070/080/095)
    ├── images/   # 1137 AVIF (s0001..s1137)
    ├── stt/tiny_en_2026_02_27/   # Moonshine model (43 MB: encoder 13 + decoder 30)
    ├── cards_content.json        # 205 karta
    └── dictionary.db
```

## Yangi dars testi qo'shish

1. `ui/grammar/practice/Lesson<N>Questions.kt` yozing.
2. `GrammarQuizRegistry.kt` dagi `lessonQuestionBanks` ga
   `N to { lesson<N>Questions }` qo'shing.
3. `GrammarScreen.kt` da shu dars guruhiga
   `GrammarTopic("N.3", "N-test. Bilimingizni sinang", "<amaliyot html>", testLesson = N)`
   qatorini qo'shing.

## Yangi unit qo'shish

1. `assets/grammar/UnitAllLessons/unit_N/` papkasini yarating.
2. `unit_N_dictionary_txt/unit_N_sentence.txt` fayliga `EN|UZ` qatorlarini
   yozing (oddiy `|` ajratgich).
3. `unit_N_sentence_opus/sNNN_075.opus` audio fayllarini qo'ying
   (0.75 tezlikda sintez qiling).
4. `GrammarScreen.kt` dagi `grammarUnits` ro'yxatiga yangi `GrammarUnit`
   qo'shing.

## Yangi card qo'shish

1. `assets/cards_content.json` ga yangi obyekt qo'shing:
   ```json
   { "id": "L07-C01", "lessonId": 7, "type": "grammar",
     "prompt": "I ___ a student. (am/is/are)", "answer": "am",
     "audioFile": null, "example": "I am a student.",
     "tags": "[\"verb_to_be\"]" }
   ```
2. `CardDatabase.kt` dagi `version` ni oshiring (destructive migration
   progressni tozalaydi).

## Ishga tushirish

1. Loyihani Android Studio da oching.
2. `local.properties` da `sdk.dir` to'g'ri ko'rsatilganini tekshiring.
3. **Run ▶** (minSdk 26).

## Eslatmalar

- `build/`, `.gradle/`, `local.properties`, `.kotlin/` gitga kirmaydi.
- `noCompress` — `.opus`, `.avif`, `.ort` siqilmaydi (tez asset o'qish uchun).
- `cards.db` da `fallbackToDestructiveMigration` ishlatiladi: `version`
  oshirilsa, o'quvchi progressi o'chadi.
- Dars HTML dagi ranglar bir xil palitrada (`#174a6b`, `#2e7ea3`,
  `#eef6fe`, fon `#f5f7fa`) — yangi sahifa qo'shganda shuni saqlang.
- Rasmlar uchun `sNNN.avif` nomlash qoidasi: `SentenceImageNaming`.
- Audio uchun `sNNN_080.opus`: tezlik `070` / `080` / `095`.
