package org.example.Tree
/**
 * Задача: Проверить, является ли бинарное дерево сбалансированным.
 *
 * Сбалансированное бинарное дерево — это дерево, в котором для каждого узла
 * высота левого и правого поддерева отличается не более чем на 1.
 *
 * Примеры:
 * Вход: [3,9,20,null,null,15,7] → true
 * Вход: [1,2,2,3,3,null,null,4,4] → false
 */

// Класс с методом проверки сбалансированности
class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) != -1
    }

    private fun checkHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val left = checkHeight(node.left)
        if (left == -1) return -1 // левое поддерево несбалансировано

        val right = checkHeight(node.right)
        if (right == -1) return -1 // правое поддерево несбалансировано

        if (kotlin.math.abs(left - right) > 1) return -1 // проверка баланса

        return 1 + maxOf(left, right)
    }
}

// Тестируем решение
fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val solution = BalancedBinaryTree()
    println(solution.isBalanced(root)) // true

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(2)
    root2.left?.left = TreeNode(3)
    root2.left?.right = TreeNode(3)
    root2.left?.left?.left = TreeNode(4)
    root2.left?.left?.right = TreeNode(4)

    println(solution.isBalanced(root2)) // false
}
