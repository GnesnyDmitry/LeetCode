package org.example.Lists

/**
 * 217. Contains Duplicate
 * Easy
 *
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element is distinct.
 *
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: true
 */
class ContainsDuplicateSolution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()

        for (num in nums) {
            if (!set.add(num)) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val solution = ContainsDuplicateSolution()
    println(solution.containsDuplicate(intArrayOf(1, 2, 3, 1))) // true
    println(solution.containsDuplicate(intArrayOf(1, 2, 3, 4))) // false
}
