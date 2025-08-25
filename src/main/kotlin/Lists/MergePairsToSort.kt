package org.example.Lists
fun main() {
    val mergePairsToSort = MergePairsToSort()
    val list = listOf(5, 2, 3, 1)
    val operationsCount = mergePairsToSort.minimumPairRemoval(list)
    println("Input: $list \nOutput: $operationsCount")
}

class MergePairsToSort {
//    Дан массив nums. Ты можешь выполнять следующую операцию любое количество раз:
//
//    Выбери смежную пару элементов с минимальной суммой в массиве nums. Если таких пар несколько, выбери самую левую.
//
//    Замени эту пару их суммой.
//
//    Верни минимальное количество операций, необходимых для того, чтобы массив стал неубывающим.
//
//    Массив считается неубывающим, если каждый его элемент больше или равен предыдущему (если он существует).
//
//
//
//    Example 1:
//
//    Input: nums = [5,2,3,1]
//
//    Output: 2
//
//    Explanation:
//
//    The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
//    The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
//    The array nums became non-decreasing in two operations.
//
//    Example 2:
//
//    Input: nums = [1,2,2]
//
//    Output: 0
//
//    Explanation:
//
//    The array nums is already sorted.

    fun minimumPairRemoval(nums: List<Int>): Int {
        val mutableNums = nums.toMutableList()
        var operationsCount = 0

        while (!isSorted(mutableNums)) {
            var minSum = Int.MAX_VALUE
            var minIndex = 0
            for (i in 0 until mutableNums.size - 1) {
                val sum = mutableNums[i] + mutableNums[i + 1]
                if (sum < minSum) {
                    minSum = sum
                    minIndex = i
                }
            }

            mutableNums[minIndex] = mutableNums[minIndex] + mutableNums[minIndex + 1]
            mutableNums.removeAt(minIndex + 1)
            operationsCount++
        }
        return operationsCount
    }

    private fun isSorted(list: List<Int>): Boolean {
        return list.zipWithNext().all { (a, b) -> a <= b }
    }
}