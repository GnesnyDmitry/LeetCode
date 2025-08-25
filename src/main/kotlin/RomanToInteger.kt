package org.example

//| Символ | Значение |
//| ------ | -------- |
//| I      | 1        |
//| V      | 5        |
//| X      | 10       |
//| L      | 50       |
//| C      | 100      |
//| D      | 500      |
//| M      | 1000     |
//Например, число 2 записывается как II — просто дважды единица. Число 12 записывается как XII, что есть X + II. Число 27 записывается как XXVII, то есть XX + V + II.
//
//Римские числа обычно записываются от большего к меньшему слева направо. Однако для некоторых чисел используется правило вычитания. Например, число 4 записывается не как IIII, а как IV, поскольку единица стоит перед пятёркой, и её нужно вычесть: 5 - 1 = 4. То же самое с числом 9, которое записывается как IX.
//
//Есть шесть случаев, когда используется вычитание:
//
//I может стоять перед V (5) и X (10), чтобы образовать 4 и 9.
//
//X может стоять перед L (50) и C (100), чтобы образовать 40 и 90.
//
//C может стоять перед D (500) и M (1000), чтобы образовать 400 и 900.
//
//Задача:
//Дан римский числ (строка). Преобразуйте его в целое число (int).


fun main() {
    val solution = SolutionRomanToInteger()
    val input = "MCMXCIV" // Пример: 1994
    val result = solution.romanToInt(input)
    println("Результат: $result") // Должно вывести: 1994

    //Лучший вариант
    val solution2 = SolutionSolutionRomanToInteger2()
    val input2 = "MCMXCIV"
    val result2 = solution2.romanToInt(input2)
    println("Результат2: $result2") // Должно вывести: 1994
}

class SolutionRomanToInteger() {
    fun romanToInt(s: String): Int {
        var result = 0
        for (i in 0 until s.length - 1) {
            val current = checkSymbol(s[i])
            val next = checkSymbol(s[i + 1])
            if (current < next) {
                result -= current
            } else {
                result += current
            }
        }
        return result + checkSymbol(s.last())
    }

    fun checkSymbol(symbol: Char): Int {
        return when (symbol) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}

class SolutionSolutionRomanToInteger2() {
    fun romanToInt(s: String): Int {
        // 1. Create a Map for Roman Numeral Values
        val translations = mapOf(
            "I" to 1,
            "V" to 5,
            "X" to 10,
            "L" to 50,
            "C" to 100,
            "D" to 500,
            "M" to 1000
        )

        // 2. Preprocess the Input String (Subtractive Notation Handling)
        var modifiedString = s
            .replace("IV", "IIII")
            .replace("IX", "VIIII")
            .replace("XL", "XXXX")
            .replace("XC", "LXXXX")
            .replace("CD", "CCCC")
            .replace("CM", "DCCCC")

        // 3. Initialize the Result Variable
        var number = 0

        // 4. Iterate Through the String and Sum Values
        for (char in modifiedString) {
            number += translations.getValue(char.toString()) // Get value from map and add to total
        }

        // 5. Return the Final Result
        return number
    }
}
