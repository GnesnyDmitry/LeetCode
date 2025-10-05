package org.example.Lists

/**
 * Дано целое число, представленное в виде массива цифр `digits`, где каждая цифра — это элемент массива.
 * Цифры упорядочены от наиболее значимой к наименее значимой (слева направо).
 * В массиве нет ведущих нулей.
 *
 * Нужно увеличить это число на единицу и вернуть новый массив цифр.
 *
 * Примеры:
 *
 * Вход: digits = [1,2,3]
 * Выход: [1,2,4]
 * Объяснение: число 123 + 1 = 124.
 *
 * Вход: digits = [4,3,2,1]
 * Выход: [4,3,2,2]
 * Объяснение: число 4321 + 1 = 4322.
 *
 * Вход: digits = [9]
 * Выход: [1,0]
 * Объяснение: число 9 + 1 = 10.
 */
class PlusOneSolution {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            } else {
                digits[i] = 0
            }
        }
        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }
}

fun main() {
    val solution = PlusOneSolution()

    val case1 = intArrayOf(1, 2, 3)
    println(solution.plusOne(case1).joinToString()) // [1, 2, 4]

    val case2 = intArrayOf(4, 3, 2, 1)
    println(solution.plusOne(case2).joinToString()) // [4, 3, 2, 2]

    val case3 = intArrayOf(9)
    println(solution.plusOne(case3).joinToString()) // [1, 0]
}
