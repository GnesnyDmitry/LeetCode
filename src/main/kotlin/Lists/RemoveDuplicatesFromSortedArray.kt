package org.example.Lists

fun main() {
    val nums = intArrayOf(1, 1, 2, 3, 3)
    val k = removeDuplicates(nums)

    println("k = $k")
    println("Уникальные элементы: ${nums.take(k)}")
}

fun removeDuplicates(nums: IntArray): Int {
    var counter = 0

    for (i in 1 until nums.size) {
        if (nums[counter] != nums[i]) {
            counter++
            nums[counter] = nums[i]
        }
    }
    return counter + 1
}
