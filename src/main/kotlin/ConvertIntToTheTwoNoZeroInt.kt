package org.example

/**
 * Решение задачи "Find Two Non-negative Integers Without Zero Digits".
 *
 * Сравниваются два подхода:
 * 1. SolutionByDivision — проверка наличия нуля через деление на 10.
 * 2. SolutionByString   — проверка через строковое представление числа.
 *
 * Оба метода перебирают первое число, второе вычисляют как (n - первое),
 * и возвращают пару, если оба числа не содержат цифру '0'.
 */

class SolutionByDivision {
    fun getNoZeroIntegers(n: Int): IntArray {
        for (i in 1 until n) {
            if (!isNonZero(i)) continue
            if (isNonZero(n - i)) {
                return intArrayOf(i, n - i)
            }
        }
        throw IllegalArgumentException("Не найдено подходящих чисел (по условию задачи такого быть не должно)")
    }

    private fun isNonZero(num: Int): Boolean {
        var x = num
        while (x > 0) {
            if (x % 10 == 0) return false
            x /= 10
        }
        return true
    }
}

class SolutionByString {
    fun getNoZeroIntegers(n: Int): IntArray {
        for (num1 in 1 until n) {
            val num2 = n - num1
            if (!num1.toString().contains('0') && !num2.toString().contains('0')) {
                return intArrayOf(num1, num2)
            }
        }
        return intArrayOf()
    }
}

fun main() {
    val n = 101

    val sol1 = SolutionByDivision()
    val res1 = sol1.getNoZeroIntegers(n)
    println("Division method: ${res1.joinToString()}")

    val sol2 = SolutionByString()
    val res2 = sol2.getNoZeroIntegers(n)
    println("String method: ${res2.joinToString()}")
}
