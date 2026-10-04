package com.example.gujumenglish.ui.grammar.practice

internal val lesson38Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Is yoki Are?",
        prompt = "There ___ a lamp on the desk.",
        answers = setOf("is"),
        explanation = "Bitta narsa: is."
    ),
    Question.Text(
        section = "1-mashq • Is yoki Are?",
        prompt = "There ___ two windows in the room.",
        answers = setOf("are"),
        explanation = "Bir nechta: are."
    ),
    Question.Text(
        section = "1-mashq • Is yoki Are?",
        prompt = "There ___ some water in the bottle.",
        answers = setOf("is"),
        explanation = "Sanalmaydigan narsa: is."
    ),
    Question.Text(
        section = "1-mashq • Is yoki Are?",
        prompt = "___ there a bank near here?",
        answers = setOf("Is"),
        explanation = "Savolda bitta narsa: Is."
    ),
    Question.Text(
        section = "1-mashq • Is yoki Are?",
        prompt = "___ there any students in the classroom?",
        answers = setOf("Are"),
        explanation = "Savolda bir nechta: Are."
    ),
    Question.Text(
        section = "2-mashq • Darak gapni inkor qiling",
        prompt = "There is a cat in the garden. — inkor shaklini yozing.",
        answers = setOf("There isn’t a cat in the garden."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: There isn’t a cat in the garden."
    ),
    Question.Text(
        section = "2-mashq • Darak gapni inkor qiling",
        prompt = "There are chairs in the kitchen. — inkor shaklini yozing.",
        answers = setOf("There aren’t chairs in the kitchen."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: There aren’t chairs in the kitchen."
    ),
    Question.Text(
        section = "2-mashq • Darak gapni inkor qiling",
        prompt = "There is milk in the fridge. — inkor shaklini yozing.",
        answers = setOf("There isn’t milk in the fridge."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: There isn’t milk in the fridge."
    ),
    Question.Text(
        section = "2-mashq • Darak gapni inkor qiling",
        prompt = "There are two parks near my house. — inkor shaklini yozing.",
        answers = setOf("There aren’t two parks near my house."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: There aren’t two parks near my house."
    ),
    Question.Ordering(
        section = "3-mashq • Savol shakliga o‘tkazing",
        prompt = "There is a library near here. — savolga o‘tkazing.",
        words = listOf("Is", "there", "a library", "near here"),
        answer = "Is there a library near here?",
        explanation = "To‘g‘ri savol: Is there a library near here?"
    ),
    Question.Ordering(
        section = "3-mashq • Savol shakliga o‘tkazing",
        prompt = "There are three apples in the bag. — savolga o‘tkazing.",
        words = listOf("Are", "there", "three apples", "in the bag"),
        answer = "Are there three apples in the bag?",
        explanation = "To‘g‘ri savol: Are there three apples in the bag?"
    ),
    Question.Ordering(
        section = "3-mashq • Savol shakliga o‘tkazing",
        prompt = "There is any juice in the glass. — savolga o‘tkazing.",
        words = listOf("Is", "there", "any juice", "in the glass"),
        answer = "Is there any juice in the glass?",
        explanation = "To‘g‘ri savol: Is there any juice in the glass?"
    ),
    Question.Text(
        section = "4-mashq • Qisqa javobni to‘ldiring",
        prompt = "Is there a bus stop nearby? (ha) — Yes, there ___.",
        answers = setOf("is"),
        explanation = "To‘g‘ri javob: Yes, there is."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javobni to‘ldiring",
        prompt = "Are there any eggs? (yo‘q) — No, there ___.",
        answers = setOf("aren’t"),
        explanation = "To‘g‘ri javob: No, there aren’t."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javobni to‘ldiring",
        prompt = "Is there water in the jug? (yo‘q) — No, there ___.",
        answers = setOf("isn’t"),
        explanation = "To‘g‘ri javob: No, there isn’t."
    ),
    Question.Choice(
        section = "5-mashq • There is/are yoki It is?",
        prompt = "___ a book on the table. (kitob bor)",
        options = listOf("There is", "It is"),
        answer = "There is",
        explanation = "Borligini aytadi: There is."
    ),
    Question.Choice(
        section = "5-mashq • There is/are yoki It is?",
        prompt = "___ my book. (u mening kitobim)",
        options = listOf("There is", "It is"),
        answer = "It is",
        explanation = "Aniq narsa haqida: It is."
    ),
    Question.Choice(
        section = "5-mashq • There is/are yoki It is?",
        prompt = "___ two dogs in the yard. (itlar bor)",
        options = listOf("There are", "It is"),
        answer = "There are",
        explanation = "Bir nechta bor: There are."
    ),
    Question.Choice(
        section = "5-mashq • There is/are yoki It is?",
        prompt = "___ very small. (mushuk juda kichkina)",
        options = listOf("There is", "It is"),
        answer = "It is",
        explanation = "Aniq narsaning holati: It is."
    ),
    Question.Ordering(
        section = "6-mashq • Rasmli vaziyatni gap bilan tasvirlang",
        prompt = "Xonada bitta stol bor — gapni tuzing.",
        words = listOf("Is", "There", "a table", "in the room"),
        answer = "There is a table in the room.",
        explanation = "To‘g‘ri gap: There is a table in the room."
    ),
    Question.Ordering(
        section = "6-mashq • Rasmli vaziyatni gap bilan tasvirlang",
        prompt = "Xonada ikkita stul bor — gapni tuzing.",
        words = listOf("Are", "There", "two chairs"),
        answer = "There are two chairs.",
        explanation = "To‘g‘ri gap: There are two chairs."
    ),
    Question.Ordering(
        section = "6-mashq • Rasmli vaziyatni gap bilan tasvirlang",
        prompt = "Xonada suv yo‘q — inkor gapni tuzing.",
        words = listOf("There", "any water", "isn’t"),
        answer = "There isn’t any water.",
        explanation = "To‘g‘ri gap: There isn’t any water."
    )
)