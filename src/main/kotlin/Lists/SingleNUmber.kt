package org.example.Lists

/**
 * Задача: Single Number
 *
 * Дан массив целых чисел, где каждое число встречается ровно дважды,
 * кроме одного уникального числа. Нужно найти это уникальное число.
 *
 * Условие:
 * - Решение должно иметь линейную сложность O(n)
 * - Использовать только O(1) дополнительной памяти
 *
 * Пример:
 * Вход: [4, 1, 2, 1, 2]
 * Выход: 4
 */
class UniqueNumberFinder {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (n in nums) {
            result = result xor n
        }
        return result
    }
}

// Для теста в IDEA
fun main() {
    val finder = UniqueNumberFinder()
    val nums = intArrayOf(4, 1, 2, 1, 2)
    println(finder.singleNumber(nums)) // 👉 4
}
