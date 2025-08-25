package org.example.Lists

//Дан отсортированный массив различных целых чисел nums и целевое значение target.
//Нужно вернуть индекс, по которому находится target, если он присутствует в массиве.
//Если target отсутствует, вернуть индекс, куда бы его вставили, чтобы массив остался отсортированным.
//
//Алгоритм должен работать за O(log n).
//
//Вход: nums = [1, 3, 5, 6], target = 5
//Выход: 2
//
//Вход: nums = [1, 3, 5, 6], target = 2
//Выход: 1
//
//Вход: nums = [1, 3, 5, 6], target = 7
//Выход: 4


class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (target == nums[mid]) {
                return mid
            }

            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }
}

fun main() {
    val solution = SearchInsertPosition()

    val nums = intArrayOf(1, 3, 5, 6)
    val target = 2
    val result = solution.searchInsert(nums, target)

    println("Результат: $result") // Ожидается: 1
}
