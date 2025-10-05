package org.example

/**
 * Задача: Сложение двух бинарных строк.
 *
 * Даны две бинарные строки a и b. Вернуть их сумму в виде бинарной строки.
 *
 * Примеры:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Ограничения:
 * - 1 <= a.length, b.length <= 10^4
 * - a и b состоят только из символов '0' и '1'
 * - Строки не содержат ведущих нулей (кроме "0")
 */

class BinaryAdder {
    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        var carry = 0

        while (i >= 0 || j >= 0 || carry > 0) {
            val bitA = if (i >= 0) a[i] - '0' else 0
            val bitB = if (j >= 0) b[j] - '0' else 0

            val sum = bitA + bitB + carry
            sb.append(sum % 2)
            carry = sum / 2

            i--
            j--
        }

        return sb.reverse().toString()
    }
}

// Пример запуска в IDEA
fun main() {
    val adder = BinaryAdder()
    println(adder.addBinary("11", "1"))       // Output: 100
    println(adder.addBinary("1010", "1011"))  // Output: 10101
}
