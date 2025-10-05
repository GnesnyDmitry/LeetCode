package org.example

/**
 * Задача: Excel Sheet Column Title (LeetCode 168)
 *
 * Дана положительная целочисленная переменная columnNumber.
 * Нужно преобразовать её в заголовок столбца Excel:
 *
 * Примеры:
 * 1  -> "A"
 * 28 -> "AB"
 * 701 -> "ZY"
 */
class ExcelColumnTitle {
    fun convertToTitle(columnNumber: Int): String {
        var n = columnNumber
        val sb = StringBuilder()

        while (n != 0) {
            n-- // сдвигаем на 1, т.к. A = 1
            val char = 'A' + (n % 26)
            sb.append(char)
            n /= 26
        }
        return sb.reverse().toString()
    }
}

fun main() {
    val solution = ExcelColumnTitle()
    println(solution.convertToTitle(1))    // A
    println(solution.convertToTitle(28))   // AB
    println(solution.convertToTitle(701))  // ZY
    println(solution.convertToTitle(2147483647)) // проверка на большое число
}
