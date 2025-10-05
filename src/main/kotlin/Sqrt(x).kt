package org.example

/**
 * Задача: Найти целочисленный квадратный корень.
 *
 * Дано неотрицательное целое число x. Вернуть квадратный корень x, округлённый вниз до ближайшего целого числа.
 * Возвращаемое число должно быть неотрицательным.
 *
 * Примеры:
 * Input: x = 4
 * Output: 2
 *
 * Input: x = 8
 * Output: 2
 *
 * Ограничения:
 * - 0 <= x <= 2^31 - 1
 * - Нельзя использовать встроенные функции возведения в степень или извлечения корня.
 */

class SqrtCalculator {
    fun mySqrt(x: Int): Int {
        if (x < 2) return x

        var left = 1
        var right = x / 2
        var result = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid.toLong() * mid <= x) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}

// Пример запуска в IDEA
fun main() {
    val calculator = SqrtCalculator()
    println(calculator.mySqrt(4))  // Output: 2
    println(calculator.mySqrt(8))  // Output: 2
    println(calculator.mySqrt(0))  // Output: 0
    println(calculator.mySqrt(1))  // Output: 1
    println(calculator.mySqrt(15)) // Output: 3
}
