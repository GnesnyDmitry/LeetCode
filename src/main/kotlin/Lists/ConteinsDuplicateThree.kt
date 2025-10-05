package org.example.Lists

/**
 * Задача:
 * Дано целочисленный массив nums и два числа indexDiff и valueDiff.
 * Нужно определить, существует ли пара индексов (i, j) такая, что:
 *   1. i != j
 *   2. abs(i - j) <= indexDiff
 *   3. abs(nums[i] - nums[j]) <= valueDiff
 * Если такая пара существует — вернуть true, иначе false.
 */

import java.util.TreeSet

class NearbyAlmostDuplicateChecker {

    fun hasNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
        // TreeSet хранит элементы текущего окна размера indexDiff в отсортированном виде
        val set = TreeSet<Long>()

        for (i in nums.indices) {
            val num = nums[i].toLong()

            // Ищем элемент в диапазоне [num - valueDiff, num + valueDiff]
            val candidate = set.ceiling(num - valueDiff)
            if (candidate != null && candidate <= num + valueDiff) {
                return true
            }

            // Добавляем текущее число в окно
            set.add(num)

            // Удаляем элемент, который выходит за предел окна indexDiff
            if (set.size > indexDiff) {
                set.remove(nums[i - indexDiff].toLong())
            }
        }
        return false
    }
}

// Пример использования
fun main() {
    val checker = NearbyAlmostDuplicateChecker()

    val nums1 = intArrayOf(1, 2, 3, 1)
    println(checker.hasNearbyAlmostDuplicate(nums1, indexDiff = 3, valueDiff = 0)) // true

    val nums2 = intArrayOf(1, 5, 9, 1, 5, 9)
    println(checker.hasNearbyAlmostDuplicate(nums2, indexDiff = 2, valueDiff = 3)) // false
}
