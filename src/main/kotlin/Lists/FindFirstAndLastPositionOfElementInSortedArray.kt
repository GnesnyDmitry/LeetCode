package org.example.Lists

//Дан массив целых чисел nums, отсортированный в неубывающем порядке.
// Найди начальную и конечную позиции заданного значения target.
//
//Если target не найден в массиве, верни [-1, -1].

class SolutionFindFirstAndLastPositionOfElementSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = binarySearch(nums, target, true)
        if (first == -1) return intArrayOf(-1, -1)
        val second = binarySearch(nums, target, false)
        return intArrayOf(first, second)
    }

    private fun binarySearch(array: IntArray, target: Int, isFirst: Boolean): Int {
        var left = 0
        var right = array.size - 1
        var result = -1

        while (left <= right) {
            val mid = (left + right) / 2
            when {
                array[mid] < target -> left = mid + 1
                array[mid] > target -> right = mid - 1
                else -> {
                    result = mid
                    if (isFirst) right = mid - 1 else left = mid + 1
                }
            }
        }
        return result
    }
}

fun main() {
    val solution = SolutionFindFirstAndLastPositionOfElementSortedArray()

    val nums1 = intArrayOf(5, 7, 7, 8, 8, 10)
    val target1 = 8
    println(solution.searchRange(nums1, target1).toList()) // [3, 4]

    val nums2 = intArrayOf(5, 7, 7, 8, 8, 10)
    val target2 = 6
    println(solution.searchRange(nums2, target2).toList()) // [-1, -1]

    val nums3 = intArrayOf()
    val target3 = 0
    println(solution.searchRange(nums3, target3).toList()) // [-1, -1]
}
