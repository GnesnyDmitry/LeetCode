package org.example.Tree

/**
 * 🧩 Задача:
 * Инвертировать бинарное дерево (зеркально отразить его).
 *
 * Для каждого узла поменять местами левое и правое поддерево.
 *
 * Пример:
 *      4
 *     / \
 *    2   7
 *   / \ / \
 *  1  3 6  9
 *
 * После инверсии:
 *      4
 *     / \
 *    7   2
 *   / \ / \
 *  9  6 3  1
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        // Рекурсивно инвертируем левое и правое поддерево
        val left = invertTree(root.left)
        val right = invertTree(root.right)

        // Меняем их местами
        root.left = right
        root.right = left

        return root
    }
}

/**
 * 💡 Пример использования:
 */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(3)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(9)

    val inverted = Solution().invertTree(root)
    println("Дерево инвертировано успешно ✅")
}
