package com.example.gujumenglish.ui.grammar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

internal data class GrammarTopic(
    val number: String,
    val title: String,
    val assetName: String? = null,
    val testLesson: Int? = null
) {
    /** Amaliyot HTML sahifasi bo'lsa true (sarlavhada "amaliyot" so'zi bor). */
    val isPractice: Boolean
        get() = title.contains("amaliyot", ignoreCase = true)
    /** Alohida interaktiv testi bor band bo'lsa true. */
    val isTest: Boolean
        get() = testLesson != null
}

internal data class GrammarUnit(
    val label: String,
    val title: String,
    val topics: List<GrammarTopic>
)

private val grammarUnits = listOf(
    GrammarUnit(
        "UNIT 0",
        "English Basics",
        listOf(
            GrammarTopic("1.1", "1-dars. Boshlang‘ich lug‘at", "UnitAllLessons/unit_0/1_Dictionary.html"),
            GrammarTopic("1.2", "1-amaliyot. Boshlang‘ich lug‘at", "UnitAllLessons/unit_0/1_Practice_Dictionary.html"),
            GrammarTopic("1.3", "1-test. Bilimingizni sinang", "UnitAllLessons/unit_0/1_Practice_Dictionary.html", testLesson = 1),
            GrammarTopic("2.1", "2-dars. English Alphabet — Ingliz alifbosi", "UnitAllLessons/unit_0/2_English_Alphabet.html"),
            GrammarTopic("2.2", "2-amaliyot. English Alphabet", "UnitAllLessons/unit_0/2_Practice_English_Alphabet.html"),
            GrammarTopic("2.3", "2-test. Bilimingizni sinang", "UnitAllLessons/unit_0/2_Practice_English_Alphabet.html", testLesson = 2),
            GrammarTopic("3.1", "3-dars. Vowels and Consonants", "UnitAllLessons/unit_0/3_Vowels_Consonants.html"),
            GrammarTopic("3.2", "3-amaliyot. Vowels and Consonants", "UnitAllLessons/unit_0/3_Practice_Vowels_Consonants.html"),
            GrammarTopic("3.3", "3-test. Bilimingizni sinang", "UnitAllLessons/unit_0/3_Practice_Vowels_Consonants.html", testLesson = 3),
            GrammarTopic("4.1", "4-dars. Letters vs Sounds — Harflar va tovushlar", "UnitAllLessons/unit_0/4_Letters_vs_Sounds.html"),
            GrammarTopic("4.2", "4-amaliyot. Letters vs Sounds", "UnitAllLessons/unit_0/4_Practice_Letters_vs_Sounds.html"),
            GrammarTopic("4.3", "4-test. Bilimingizni sinang", "UnitAllLessons/unit_0/4_Practice_Letters_vs_Sounds.html", testLesson = 4),
            GrammarTopic("5.1", "5-dars. Letter Combinations — Harf birikmalari", "UnitAllLessons/unit_0/5_Letter_Combinations.html"),
            GrammarTopic("5.2", "5-amaliyot. Letter Combinations", "UnitAllLessons/unit_0/5_Practice_Letter_Combinations.html"),
            GrammarTopic("6.1", "6-dars. Silent Letters — O‘qilmaydigan harflar", "UnitAllLessons/unit_0/6_Silent_Letters.html"),
            GrammarTopic("6.2", "6-amaliyot. Silent Letters", "UnitAllLessons/unit_0/6_Practice_Silent_Letters.html"),
        )
    ),
    GrammarUnit(
        "UNIT 1",
        "Foundation",
        listOf(
            GrammarTopic("7.1", "7-dars. Noun and Pronoun — Ot va olmosh", "UnitAllLessons/unit_1/7_Noun_and_Pronoun.html"),
            GrammarTopic("7.2", "7-amaliyot. Noun and Pronoun", "UnitAllLessons/unit_1/7_Practice_Noun_Pronoun.html"),
            GrammarTopic("8.1", "8-dars. Singular and Plural Nouns", "UnitAllLessons/unit_1/8_Singular_and_Plural_Nouns.html"),
            GrammarTopic("8.2", "8-amaliyot. Singular and Plural Nouns", "UnitAllLessons/unit_1/8_Practice_Singular_Plural_Nouns.html"),
            GrammarTopic("9.1", "9-dars. Subject Pronouns — Ega olmoshlari", "UnitAllLessons/unit_1/9_Subject_Pronouns_I_You_He_She_It_We_They.html"),
            GrammarTopic("9.2", "9-amaliyot. Subject Pronouns", "UnitAllLessons/unit_1/9_Practice_Subject_Pronouns.html"),
            GrammarTopic("10.1", "10-dars. Verb To Be — am/is/are", "UnitAllLessons/unit_1/10_Verb_To_Be_am_is_are.html"),
            GrammarTopic("10.2", "10-amaliyot. To Be — Am / Is / Are", "UnitAllLessons/unit_1/10_Practice_To_Be_Am_Is_Are.html"),
            GrammarTopic("11.1", "11-dars. To Be — Negative and Questions", "UnitAllLessons/unit_1/11_To_Be_Negative_and_Questions.html"),
            GrammarTopic("11.2", "11-amaliyot. To Be — Inkor va Savollar", "UnitAllLessons/unit_1/11_Practice_To_Be_Negative_Questions.html"),
            GrammarTopic("12.1", "12-dars. Indefinite Article — A / An", "UnitAllLessons/unit_1/12_Indefinite_Article_a _an.html"),
            GrammarTopic("12.2", "12-amaliyot. A / An", "UnitAllLessons/unit_1/12_Practice_A_An.html"),
            GrammarTopic("13.1", "13-dars. The — Definite Article (Batafsil)", "UnitAllLessons/unit_1/13_The_Definite_Article.html"),
            GrammarTopic("13.2", "13-amaliyot. The Artikli", "UnitAllLessons/unit_1/13_Practice_The_Article.html"),
            GrammarTopic("14.1", "14-dars. Demonstratives — This, That, These, Those", "UnitAllLessons/unit_1/14_Demonstratives_This_That_These_Those.html"),
            GrammarTopic("14.2", "14-amaliyot. This / That / These / Those", "UnitAllLessons/unit_1/14_Practice_This_That_These_Those.html"),
            GrammarTopic("15.1", "15-dars. Possessive Adjectives", "UnitAllLessons/unit_1/15_Possessive_Adjectives.html"),
            GrammarTopic("15.2", "15-amaliyot. Possessive Adjectives", "UnitAllLessons/unit_1/15_Practice_Possessive_Adjectives.html"),
            GrammarTopic("16.1", "16-dars. Possessive ’s", "UnitAllLessons/unit_1/16_Possessive_S.html"),
            GrammarTopic("16.2", "16-amaliyot. Possessive ’s", "UnitAllLessons/unit_1/16_Practice_Possessive_S.html"),
            GrammarTopic("17.1", "17-dars. Have / Has", "UnitAllLessons/unit_1/17_Have_Has.html"),
            GrammarTopic("17.2", "17-amaliyot. Have / Has", "UnitAllLessons/unit_1/17_Practice_Have_Has.html"),
            GrammarTopic("18.1", "18-dars. Possessive Pronouns", "UnitAllLessons/unit_1/18_Possessive_Pronouns.html"),
            GrammarTopic("18.2", "18-amaliyot. Possessive Pronouns", "UnitAllLessons/unit_1/18_Practice_Possessive_Pronouns.html"),
        )
    ),
    GrammarUnit(
        "UNIT 2",
        "Present",
        listOf(
            GrammarTopic("19.1", "19-dars. Basic Sentence Structure — Subject + Verb + Object", "UnitAllLessons/unit_2/19_Basic_Sentence_Structure.html"),
            GrammarTopic("19.2", "19-amaliyot. Basic Sentence Structure", "UnitAllLessons/unit_2/19_Practice_Sentence_Structure.html"),
            GrammarTopic("20.1", "20-dars. Present Simple — Affirmative", "UnitAllLessons/unit_2/20_Present_Simple_Affirmative.html"),
            GrammarTopic("20.2", "20-amaliyot. Present Simple — Darak gaplar", "UnitAllLessons/unit_2/20_Practice_Present_Simple_Affirmative.html"),
            GrammarTopic("21.1", "21-dars. Present Simple — He / She / It + s", "UnitAllLessons/unit_2/21_Present_Simple_He_She_It.html"),
            GrammarTopic("21.2", "21-amaliyot. He / She / It + S", "UnitAllLessons/unit_2/21_Practice_Present_Simple_He_She_It.html"),
            GrammarTopic("22.1", "22-dars. Present Simple — Negative", "UnitAllLessons/unit_2/22_Present_Simple_Negative.html"),
            GrammarTopic("22.2", "22-amaliyot. Present Simple — Inkor", "UnitAllLessons/unit_2/22_Practice_Present_Simple_Negative.html"),
            GrammarTopic("23.1", "23-dars. Do / Does — Present Simple", "UnitAllLessons/unit_2/23_Do_Does.html"),
            GrammarTopic("23.2", "23-amaliyot. Do / Does", "UnitAllLessons/unit_2/23_Practice_Do_Does.html"),
            GrammarTopic("24.1", "24-dars. Present Simple Questions", "UnitAllLessons/unit_2/24_Present_Simple_Questions.html"),
            GrammarTopic("24.2", "24-amaliyot. Present Simple — Savollar", "UnitAllLessons/unit_2/24_Practice_Present_Simple_Questions.html"),
            GrammarTopic("25.1", "25-dars. Short Answers — Yes, I do / No, I don’t", "UnitAllLessons/unit_2/25_Short_Answers.html"),
            GrammarTopic("25.2", "25-amaliyot. Short Answers", "UnitAllLessons/unit_2/25_Practice_Short_Answers.html"),
            GrammarTopic("26.1", "26-dars. Adverbs of Frequency", "UnitAllLessons/unit_2/26_Adverbs_of_Frequency.html"),
            GrammarTopic("26.2", "26-amaliyot. Adverbs of Frequency", "UnitAllLessons/unit_2/26_Practice_Adverbs_of_Frequency.html"),
            GrammarTopic("27.1", "27-dars. Present Continuous — am/is/are + -ing", "UnitAllLessons/unit_2/27_Present_Continuous.html"),
            GrammarTopic("27.2", "27-amaliyot. Present Continuous", "UnitAllLessons/unit_2/27_Practice_Present_Continuous.html"),
            GrammarTopic("28.1", "28-dars. Present Simple vs Present Continuous", "UnitAllLessons/unit_2/28_Present_Simple_vs_Present_Continuous.html"),
            GrammarTopic("28.2", "28-amaliyot. Present Simple vs Present Continuous", "UnitAllLessons/unit_2/28_Practice_Present_Simple_vs_Continuous.html"),
        )
    ),
    GrammarUnit(
        "UNIT 3",
        "Questions",
        listOf(
            GrammarTopic("29.1", "29-dars. Question Words — Savol so‘zlari", "UnitAllLessons/unit_3/29_Question_Words_Overview.html"),
            GrammarTopic("29.2", "29-amaliyot. Question Words", "UnitAllLessons/unit_3/29_Practice_Question_Words.html"),
            GrammarTopic("30.1", "30-dars. What — Nima?", "UnitAllLessons/unit_3/30_What.html"),
            GrammarTopic("30.2", "30-amaliyot. What", "UnitAllLessons/unit_3/30_Practice_What.html"),
            GrammarTopic("31.1", "31-dars. Where — Qayerda? Qayerga?", "UnitAllLessons/unit_3/31_Where.html"),
            GrammarTopic("31.2", "31-amaliyot. Where", "UnitAllLessons/unit_3/31_Practice_Where.html"),
            GrammarTopic("32.1", "32-dars. Who — Kim?", "UnitAllLessons/unit_3/32_Who.html"),
            GrammarTopic("32.2", "32-amaliyot. Who", "UnitAllLessons/unit_3/32_Practice_Who.html"),
            GrammarTopic("33.1", "33-dars. When — Qachon?", "UnitAllLessons/unit_3/33_When.html"),
            GrammarTopic("33.2", "33-amaliyot. When", "UnitAllLessons/unit_3/33_Practice_When.html"),
            GrammarTopic("34.1", "34-dars. Why — Nega? Nima uchun?", "UnitAllLessons/unit_3/34_Why.html"),
            GrammarTopic("34.2", "34-amaliyot. Why", "UnitAllLessons/unit_3/34_Practice_Why.html"),
            GrammarTopic("35.1", "35-dars. How — Qanday?", "UnitAllLessons/unit_3/35_How.html"),
            GrammarTopic("35.2", "35-amaliyot. How", "UnitAllLessons/unit_3/35_Practice_How.html"),
            GrammarTopic("36.1", "36-dars. How Old / How Long", "UnitAllLessons/unit_3/36_How_Old_How_Long.html"),
            GrammarTopic("36.2", "36-amaliyot. How Old / How Long", "UnitAllLessons/unit_3/36_Practice_How_Old_How_Long.html"),
            GrammarTopic("37.1", "37-dars. How Many / How Much", "UnitAllLessons/unit_3/37_How_Many_How_Much.html"),
            GrammarTopic("37.2", "37-amaliyot. How Many / How Much", "UnitAllLessons/unit_3/37_Practice_How_Many_How_Much.html"),
        )
    ),
    GrammarUnit(
        "UNIT 4",
        "Everyday English",
        listOf(
            GrammarTopic("38.1", "38-dars. There Is / There Are", "UnitAllLessons/unit_4/38_There_Is_There_Are.html"),
            GrammarTopic("38.2", "38-amaliyot. There Is / There Are", "UnitAllLessons/unit_4/38_Practice_There_Is_There_Are.html"),
            GrammarTopic("39.1", "39-dars. Can / Can’t — Ability", "UnitAllLessons/unit_4/39_Can_Cant_Ability.html"),
            GrammarTopic("39.2", "39-amaliyot. Can / Can't Ability", "UnitAllLessons/unit_4/39_Practice_Can_Cant_Ability.html"),
            GrammarTopic("40.1", "40-dars. Can / Can’t — Questions and Requests", "UnitAllLessons/unit_4/40_Can_Cant_Questions_Requests.html"),
            GrammarTopic("40.2", "40-amaliyot. Can Questions and Requests", "UnitAllLessons/unit_4/40_Practice_Can_Questions_Requests.html"),
            GrammarTopic("41.1", "41-dars. Imperatives — Buyruq va ko‘rsatmalar", "UnitAllLessons/unit_4/41_Imperatives.html"),
            GrammarTopic("41.2", "41-amaliyot. Imperatives", "UnitAllLessons/unit_4/41_Practice_Imperatives.html"),
            GrammarTopic("42.1", "42-dars. Prepositions of Place — Joy predloglari", "UnitAllLessons/unit_4/42_Prepositions_of_Place.html"),
            GrammarTopic("42.2", "42-amaliyot. Prepositions of Place", "UnitAllLessons/unit_4/42_Practice_Prepositions_of_Place.html"),
            GrammarTopic("43.1", "43-dars. Prepositions of Time — At / On / In", "UnitAllLessons/unit_4/43_Prepositions_of_Time.html"),
            GrammarTopic("43.2", "43-amaliyot. Prepositions of Time", "UnitAllLessons/unit_4/43_Practice_Prepositions_of_Time.html"),
            GrammarTopic("44.1", "44-dars. Countable and Uncountable Nouns", "UnitAllLessons/unit_4/44_Countable_Uncountable_Nouns.html"),
            GrammarTopic("44.2", "44-amaliyot. Countable and Uncountable Nouns", "UnitAllLessons/unit_4/44_Practice_Countable_Uncountable.html"),
            GrammarTopic("45.1", "45-dars. Some / Any", "UnitAllLessons/unit_4/45_Some_Any.html"),
            GrammarTopic("45.2", "45-amaliyot. Some / Any", "UnitAllLessons/unit_4/45_Practice_Some_Any.html"),
            GrammarTopic("46.1", "46-dars. Much / Many / A Lot Of", "UnitAllLessons/unit_4/46_Much_Many_A_Lot_Of.html"),
            GrammarTopic("46.2", "46-amaliyot. Much / Many / A Lot Of", "UnitAllLessons/unit_4/46_Practice_Much_Many_A_Lot_Of.html"),
            GrammarTopic("47.1", "47-dars. Object Pronouns", "UnitAllLessons/unit_4/47_Object_Pronouns.html"),
            GrammarTopic("47.2", "47-amaliyot. Object Pronouns", "UnitAllLessons/unit_4/47_Practice_Object_Pronouns.html"),
            GrammarTopic("48.1", "48-dars. Basic Adjectives — Asosiy sifatlar", "UnitAllLessons/unit_4/48_Basic_Adjectives.html"),
            GrammarTopic("48.2", "48-amaliyot. Basic Adjectives", "UnitAllLessons/unit_4/48_Practice_Basic_Adjectives.html"),
        )
    ),
    GrammarUnit(
        "UNIT 5",
        "Past",
        listOf(
            GrammarTopic("49.1", "49-dars. Past of To Be — Was / Were", "UnitAllLessons/unit_5/49_Past_Of_To_Be_Was_Were.html"),
            GrammarTopic("49.2", "49-amaliyot. Was / Were", "UnitAllLessons/unit_5/49_Practice_Was_Were.html"),
            GrammarTopic("50.1", "50-dars. Past Simple — Regular Verbs", "UnitAllLessons/unit_5/50_Past_Simple_Regular_Verbs.html"),
            GrammarTopic("50.2", "50-amaliyot. Past Simple Regular Verbs", "UnitAllLessons/unit_5/50_Practice_Past_Simple_Regular_Verbs.html"),
            GrammarTopic("51.1", "51-dars. Past Simple — Irregular Verbs", "UnitAllLessons/unit_5/51_Past_Simple_Irregular_Verbs.html"),
            GrammarTopic("51.2", "51-amaliyot. Past Simple Irregular Verbs", "UnitAllLessons/unit_5/51_Practice_Past_Simple_Irregular_Verbs.html"),
            GrammarTopic("52.1", "52-dars. Past Simple Negative — Didn’t", "UnitAllLessons/unit_5/52_Past_Simple_Negative_Didnt.html"),
            GrammarTopic("52.2", "52-amaliyot. Past Simple Negative", "UnitAllLessons/unit_5/52_Practice_Past_Simple_Negative.html"),
            GrammarTopic("53.1", "53-dars. Did / Didn’t — Past Simple", "UnitAllLessons/unit_5/53_Did_Didnt.html"),
            GrammarTopic("53.2", "53-amaliyot. Did / Didn't", "UnitAllLessons/unit_5/53_Practice_Did_Didnt.html"),
            GrammarTopic("54.1", "54-dars. Past Simple — Questions", "UnitAllLessons/unit_5/54_Past_Simple_Questions.html"),
            GrammarTopic("54.2", "54-amaliyot. Past Simple Questions", "UnitAllLessons/unit_5/54_Practice_Past_Simple_Questions.html"),
            GrammarTopic("55.1", "55-dars. Past Simple — Short Answers", "UnitAllLessons/unit_5/55_Past_Simple_Short_Answers.html"),
            GrammarTopic("55.2", "55-amaliyot. Past Simple Short Answers", "UnitAllLessons/unit_5/55_Practice_Past_Simple_Short_Answers.html"),
        )
    ),
    GrammarUnit(
        "UNIT 6",
        "Future & Description",
        listOf(
            GrammarTopic("56.1", "56-dars. Going To — Future Plans", "UnitAllLessons/unit_6/56_Going_To_Future_Plans.html"),
            GrammarTopic("56.2", "56-amaliyot. Going To Future Plans", "UnitAllLessons/unit_6/56_Practice_Going_To_Future_Plans.html"),
            GrammarTopic("57.1", "57-dars. Will — Basic Future", "UnitAllLessons/unit_6/57_Will_Basic_Future.html"),
            GrammarTopic("57.2", "57-amaliyot. Will Basic Future", "UnitAllLessons/unit_6/57_Practice_Will_Basic_Future.html"),
            GrammarTopic("58.1", "58-dars. Going To vs Will", "UnitAllLessons/unit_6/58_Going_To_vs_Will.html"),
            GrammarTopic("58.2", "58-amaliyot. Going To vs Will", "UnitAllLessons/unit_6/58_Practice_Going_To_vs_Will.html"),
            GrammarTopic("59.1", "59-dars. Comparative Adjectives", "UnitAllLessons/unit_6/59_Comparative_Adjectives.html"),
            GrammarTopic("59.2", "59-amaliyot. Comparative Adjectives", "UnitAllLessons/unit_6/59_Practice_Comparative_Adjectives.html"),
            GrammarTopic("60.1", "60-dars. Superlative Adjectives", "UnitAllLessons/unit_6/60_Superlative_Adjectives.html"),
            GrammarTopic("60.2", "60-amaliyot. Superlative Adjectives", "UnitAllLessons/unit_6/60_Practice_Superlative_Adjectives.html"),
            GrammarTopic("61.1", "61-dars. Adjective Position", "UnitAllLessons/unit_6/61_Adjective_Position.html"),
            GrammarTopic("61.2", "61-amaliyot. Adjective Position", "UnitAllLessons/unit_6/61_Practice_Adjective_Position.html"),
            GrammarTopic("62.1", "62-dars. Conjunctions — And / But / Or", "UnitAllLessons/unit_6/62_Conjunctions_And_But_Or.html"),
            GrammarTopic("62.2", "62-amaliyot. And / But / Or", "UnitAllLessons/unit_6/62_Practice_Conjunctions_And_But_Or.html"),
            GrammarTopic("63.1", "63-dars. Because / So", "UnitAllLessons/unit_6/63_Because_So.html"),
            GrammarTopic("63.2", "63-amaliyot. Because / So", "UnitAllLessons/unit_6/63_Practice_Because_So.html"),
            GrammarTopic("64.1", "64-dars. Would Like — I’d Like", "UnitAllLessons/unit_6/64_Would_Like.html"),
            GrammarTopic("64.2", "64-amaliyot. Would Like", "UnitAllLessons/unit_6/64_Practice_Would_Like.html"),
        )
    ),
    GrammarUnit(
        "UNIT 7",
        "A1 Review & Integration",
        listOf(
            GrammarTopic("65.1", "65-dars. A1 Grammar Review — Present, Past, Future", "UnitAllLessons/unit_7/65_A1_Grammar_Review_Present_Past_Future.html"),
            GrammarTopic("65.2", "65-amaliyot. A1 Grammar Review", "UnitAllLessons/unit_7/65_Practice_A1_Grammar_Review.html"),
            GrammarTopic("66.1", "66-dars. A1 Grammar Final Practice — Questions, Negatives and Sentences", "UnitAllLessons/unit_7/66_A1_Grammar_Final_Practice.html"),
            GrammarTopic("66.2", "66-amaliyot. A1 Grammar Final Practice", "UnitAllLessons/unit_7/66_Practice_A1_Grammar_Final.html"),
        )
    ),
)

internal fun groupedGrammarUnits(): List<GrammarUnit> {
    val allTopics = grammarUnits.flatMap { it.topics }
    // Har bir dars (1-66) nazariya + amaliyot juftligidan bitta ochiladigan guruh.
    // Sarlavha nazariy dars nomidan olinadi.
    val lessonTitles = mapOf(
        1 to "Boshlang‘ich lug‘at",
        2 to "English Alphabet — Ingliz alifbosi",
        3 to "Vowels and Consonants",
        4 to "Letters vs Sounds — Harflar va tovushlar",
        5 to "Letter Combinations — Harf birikmalari",
        6 to "Silent Letters — O‘qilmaydigan harflar",
        7 to "Noun and Pronoun — Ot va olmosh",
        8 to "Singular and Plural Nouns",
        9 to "Subject Pronouns — Ega olmoshlari",
        10 to "Verb To Be — am/is/are",
        11 to "To Be — Negative and Questions",
        12 to "Indefinite Article — A / An",
        13 to "The — Definite Article (Batafsil)",
        14 to "Demonstratives — This, That, These, Those",
        15 to "Possessive Adjectives",
        16 to "Possessive ’s",
        17 to "Have / Has",
        18 to "Possessive Pronouns",
        19 to "Basic Sentence Structure — Subject + Verb + Object",
        20 to "Present Simple — Affirmative",
        21 to "Present Simple — He / She / It + s",
        22 to "Present Simple — Negative",
        23 to "Do / Does — Present Simple",
        24 to "Present Simple Questions",
        25 to "Short Answers — Yes, I do / No, I don’t",
        26 to "Adverbs of Frequency",
        27 to "Present Continuous — am/is/are + -ing",
        28 to "Present Simple vs Present Continuous",
        29 to "Question Words — Savol so‘zlari",
        30 to "What — Nima?",
        31 to "Where — Qayerda? Qayerga?",
        32 to "Who — Kim?",
        33 to "When — Qachon?",
        34 to "Why — Nega? Nima uchun?",
        35 to "How — Qanday?",
        36 to "How Old / How Long",
        37 to "How Many / How Much",
        38 to "There Is / There Are",
        39 to "Can / Can’t — Ability",
        40 to "Can / Can’t — Questions and Requests",
        41 to "Imperatives — Buyruq va ko‘rsatmalar",
        42 to "Prepositions of Place — Joy predloglari",
        43 to "Prepositions of Time — At / On / In",
        44 to "Countable and Uncountable Nouns",
        45 to "Some / Any",
        46 to "Much / Many / A Lot Of",
        47 to "Object Pronouns",
        48 to "Basic Adjectives — Asosiy sifatlar",
        49 to "Past of To Be — Was / Were",
        50 to "Past Simple — Regular Verbs",
        51 to "Past Simple — Irregular Verbs",
        52 to "Past Simple Negative — Didn’t",
        53 to "Did / Didn’t — Past Simple",
        54 to "Past Simple — Questions",
        55 to "Past Simple — Short Answers",
        56 to "Going To — Future Plans",
        57 to "Will — Basic Future",
        58 to "Going To vs Will",
        59 to "Comparative Adjectives",
        60 to "Superlative Adjectives",
        61 to "Adjective Position",
        62 to "Conjunctions — And / But / Or",
        63 to "Because / So",
        64 to "Would Like — I’d Like",
        65 to "A1 Grammar Review — Present, Past, Future",
        66 to "A1 Grammar Final Practice — Questions, Negatives and Sentences"
    )
    return (1..66).mapNotNull { lesson ->
        val topics = allTopics.filter { it.number.substringBefore(".") == lesson.toString() }
        if (topics.isEmpty()) {
            null
        } else {
            GrammarUnit(
                label = "$lesson-Topic",
                title = lessonTitles[lesson] ?: topics.first().title,
                topics = topics
            )
        }
    }
}

internal fun grammarSectionFor(unitLabel: String): GrammarListItem.SectionHeader? {
    val topicNumber = unitLabel.substringBefore("-Topic").toIntOrNull()
    return when {
        unitLabel == "UNIT 0" -> GrammarListItem.SectionHeader("UNIT 0", "English Basics")
        unitLabel == "UNIT 1" -> GrammarListItem.SectionHeader("UNIT 1", "Foundation")
        unitLabel == "UNIT 2" -> GrammarListItem.SectionHeader("UNIT 2", "Present")
        unitLabel == "UNIT 3" -> GrammarListItem.SectionHeader("UNIT 3", "Questions")
        unitLabel == "UNIT 4" -> GrammarListItem.SectionHeader("UNIT 4", "Everyday English")
        unitLabel == "UNIT 5" -> GrammarListItem.SectionHeader("UNIT 5", "Past")
        unitLabel == "UNIT 6" -> GrammarListItem.SectionHeader("UNIT 6", "Future & Description")
        unitLabel == "UNIT 7" -> GrammarListItem.SectionHeader("UNIT 7", "A1 Review & Integration")
        topicNumber in 1..6 -> GrammarListItem.SectionHeader("UNIT 0", "English Basics")
        topicNumber in 7..18 -> GrammarListItem.SectionHeader("UNIT 1", "Foundation")
        topicNumber in 19..28 -> GrammarListItem.SectionHeader("UNIT 2", "Present")
        topicNumber in 29..37 -> GrammarListItem.SectionHeader("UNIT 3", "Questions")
        topicNumber in 38..48 -> GrammarListItem.SectionHeader("UNIT 4", "Everyday English")
        topicNumber in 49..55 -> GrammarListItem.SectionHeader("UNIT 5", "Past")
        topicNumber in 56..64 -> GrammarListItem.SectionHeader("UNIT 6", "Future & Description")
        topicNumber in 65..66 -> GrammarListItem.SectionHeader("UNIT 7", "A1 Review & Integration")
        else -> null
    }
}

internal sealed interface GrammarListItem {
    data class SectionHeader(val label: String, val title: String) : GrammarListItem
    data class Header(val unit: GrammarUnit) : GrammarListItem
    data class Topic(val unitLabel: String, val topic: GrammarTopic) : GrammarListItem
}

@Composable
fun GrammarScreen(
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit,
    modifier: Modifier = Modifier
) {
    SoftGrammarScreen(
        onOpenLesson = onOpenLesson,
        modifier = modifier
    )
}

@Composable
private fun GrammarUnitSection(
    section: GrammarListItem.SectionHeader,
    sectionUnits: List<GrammarUnit>,
    expandedUnitLabels: Set<String>,
    onToggleUnit: (String) -> Unit,
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = section.label,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = section.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Column(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                sectionUnits.forEach { unit ->
                    if (unit.label.startsWith("UNIT")) {
                        unit.topics.forEach { topic ->
                            GrammarTopicRow(
                                unitLabel = unit.label,
                                topic = topic,
                                onOpenLesson = onOpenLesson
                            )
                        }
                    } else {
                        GrammarUnitHeader(
                            unit = unit,
                            isExpanded = unit.label in expandedUnitLabels,
                            onToggle = { onToggleUnit(unit.label) },
                            onOpenLesson = onOpenLesson
                        )
                    }
                }
            }
        }
    }
}
@Composable
private fun GrammarSectionHeader(
    label: String,
    title: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun GrammarUnitHeader(
    unit: GrammarUnit,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit
) {
    val isExpandable = unit.label.endsWith("Topic")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = isExpandable, onClick = onToggle),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.28f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = if (isExpandable) 0.dp else 44.dp,
                        end = if (isExpandable) 44.dp else 44.dp
                    ),
                horizontalAlignment = if (isExpandable) {
                    Alignment.Start
                } else {
                    Alignment.CenterHorizontally
                }
            ) {
            Text(
                text = unit.label,
                modifier = Modifier.fillMaxWidth(),
                style = if (isExpandable) {
                    MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold)
                } else {
                    MaterialTheme.typography.labelLarge
                },
                fontWeight = if (isExpandable) FontWeight.SemiBold else FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = if (isExpandable) TextAlign.Start else TextAlign.Center
            )
            Text(
                text = unit.title,
                modifier = Modifier.fillMaxWidth(),
                style = if (isExpandable) {
                    MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                } else {
                    MaterialTheme.typography.titleLarge
                },
                fontWeight = if (isExpandable) FontWeight.SemiBold else FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = if (isExpandable) TextAlign.Start else TextAlign.Center
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isExpandable) {
                Icon(
                    imageVector = if (isExpanded) {
                        Icons.Outlined.ExpandLess
                    } else {
                        Icons.Outlined.ExpandMore
                    },
                    contentDescription = if (isExpanded) {
                        "Topic bo‘limlarini yopish"
                    } else {
                        "Topic bo‘limlarini ochish"
                    },
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        }
        if (isExpandable && isExpanded) {
            Column(
                modifier = Modifier.padding(start = 12.dp, top = 4.dp, end = 12.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                unit.topics.forEach { topic ->
                    GrammarTopicRow(
                        unitLabel = unit.label,
                        topic = topic,
                        onOpenLesson = onOpenLesson
                    )
                }
            }
        }
    }
}

@Composable
private fun GrammarTopicRow(
    unitLabel: String,
    topic: GrammarTopic,
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit
) {
    val isLessonAvailable = topic.assetName != null
    val isNestedTopic = unitLabel.endsWith("-Topic")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = if (isNestedTopic) 24.dp else 0.dp)
            .clickable(enabled = isLessonAvailable) {
                topic.assetName?.let { assetName ->
                    onOpenLesson(assetName, topic.title, topic.testLesson)
                }
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isNestedTopic) {
                MaterialTheme.colorScheme.surface
            } else {
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.22f)
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
        Text(
            text = topic.title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            color = if (isLessonAvailable) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
        if (!isLessonAvailable) {
            Text(
                text = "Tez orada",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
    }
}
