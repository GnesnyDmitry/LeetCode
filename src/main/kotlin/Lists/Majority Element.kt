package org.example.Lists

/**
 * Задача: Найти элемент, который встречается в массиве более чем n/2 раз.
 * Вход: массив целых чисел nums.
 * Выход: majority элемент (тот, который встречается чаще всего, > n/2 раз).
 *
 * Пример:
 * nums = [6, 5, 5] -> результат: 5
 * nums = [3, 3, 4] -> результат: 3
 *
 * Решение использует алгоритм Boyer-Moore:
 * - Один проход по массиву.
 * - Постоянная память O(1).
 * - Время работы O(n).
 */

class MajorityElementFinder {
    fun majorityElement(nums: IntArray): Int {
        var count = 1
        var candidate = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] == candidate) {
                count++
            } else {
                count--
            }

            if (count == 0) {
                candidate = nums[i]
                count = 1
            }
        }

        return candidate
    }
}

// Пример использования
fun main() {
    val nums1 = intArrayOf(6, 5, 5)
    val nums2 = intArrayOf(3, 3, 4)

    val finder = MajorityElementFinder()
    println(finder.majorityElement(nums1)) // 5
    println(finder.majorityElement(nums2)) // 3
}
