package org.example

//Дан массив целых чисел nums и целое число target. Необходимо вернуть индексы двух чисел из массива, сумма которых равна target.
//
//Можно считать, что в каждом входном наборе будет ровно одно решение, и нельзя использовать один и тот же элемент дважды.
//
//Ответ можно вернуть в любом порядке.

fun main() {
    val solution = Solution()

    val testCases = listOf(
        Pair(intArrayOf(2, 7, 11, 15), 9),
        Pair(intArrayOf(3, 2, 4), 6),
        Pair(intArrayOf(3, 3), 6)
    )

    for ((nums, target) in testCases) {
        val result = solution.twoSum(nums, target)
        println("Input: nums=${nums.joinToString()}, target=$target => Output: [${result.joinToString()}]")
    }
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for(i in nums.indices) {
            val necessary = target - nums[i]
            if (map.containsKey(necessary)) {
                return intArrayOf(map.getOrDefault(necessary, 0), i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}
