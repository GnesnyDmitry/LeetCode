package org.example.Lists

/**
 * Задача:
 * Дано: массив nums и число k.
 * Нужно вернуть true, если есть два одинаковых числа в массиве,
 * такие что их индексы отличаются не больше чем на k.
 *
 * Пример:
 * nums = [1,2,3,1], k = 3 → true
 * nums = [1,0,1,1], k = 1 → true
 * nums = [1,2,3,1,2,3], k = 2 → false
 */

class ContainsNearbyDuplicateSolution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = mutableSetOf<Int>()

        for (i in nums.indices) {
            if (nums[i] in set) return true

            set.add(nums[i])

            if (set.size > k) {
                set.remove(nums[i - k]) // удаляем элемент, который вышел за пределы окна
            }
        }
        return false
    }
}

fun main() {
    val solution = ContainsNearbyDuplicateSolution()

    val nums1 = intArrayOf(1, 2, 3, 1)
    println(solution.containsNearbyDuplicate(nums1, 3)) // true

    val nums2 = intArrayOf(1, 0, 1, 1)
    println(solution.containsNearbyDuplicate(nums2, 1)) // true

    val nums3 = intArrayOf(1, 2, 3, 1, 2, 3)
    println(solution.containsNearbyDuplicate(nums3, 2)) // false
}
