package org.example

/**
 * Задача: Reverse Bits
 *
 * Дано 32-битное целое число n. Необходимо перевернуть его биты и вернуть результат.
 * Например:
 * Вход:  43261596  ->  00000010100101000001111010011100 (32 бита)
 * Выход: 964176192  ->  00111001011110000010100101000000
 */

fun main() {
    val n = 43261596
    val solution = BitReverser()
    val reversed = solution.reverseBits(n)
    println("Исходное число: $n")
    println("Перевернутые биты: $reversed")
}

class BitReverser {
    fun reverseBits(n: Int): Int {
        var num = n
        var result = 0

        repeat(32) {
            // достаем последний бит числа num
            val bit = num and 1

            // сдвигаем результат влево и добавляем бит
            result = (result shl 1) or bit

            // сдвигаем исходное число вправо (логический сдвиг)
            num = num ushr 1
        }

        return result
    }
}
