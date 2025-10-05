package org.example.Lists.node

/**
 * Задача: Преобразование отсортированного массива в сбалансированное бинарное дерево поиска (BST).
 *
 * Дано: Отсортированный массив целых чисел.
 * Нужно: Построить бинарное дерево поиска, где для каждого узла левое поддерево содержит меньшие значения,
 *       а правое — большие. Дерево должно быть максимально сбалансированным.
 *
 * Пример:
 * Вход: nums = [1,2,3,4,5,6,7]
 * Выход: дерево:
 *         4
 *       /   \
 *      2     6
 *     / \   / \
 *    1   3 5   7
 */

/**
 * Определение узла бинарного дерева
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Класс для построения BST из отсортированного массива
 */
class SortedArrayToBST {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return buildBST(nums, 0, nums.size - 1)
    }

    private fun buildBST(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val mid = left + (right - left) / 2
        val node = TreeNode(nums[mid])

        node.left = buildBST(nums, left, mid - 1)
        node.right = buildBST(nums, mid + 1, right)

        return node
    }
}

/**
 * Пример использования в main()
 */
fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val builder = SortedArrayToBST()
    val root = builder.sortedArrayToBST(nums)

    println("Дерево построено. Корень: ${root?.`val`}") // 4
}
