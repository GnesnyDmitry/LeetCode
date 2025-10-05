package org.example.Tree

/**
 * Задача: Проверка симметричности бинарного дерева.
 *
 * Дано бинарное дерево, нужно проверить, является ли оно симметричным относительно центра.
 *
 * Пример 1:
 * Вход:
 *       1
 *      / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 * Выход: true
 *
 * Пример 2:
 * Вход:
 *       1
 *      / \
 *     2   2
 *      \   \
 *       3   3
 * Выход: false
 *
 * Определение узла бинарного дерева:
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class SymmetricTreeChecker {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean {
            if (t1 == null && t2 == null) return true
            if (t1 == null || t2 == null) return false
            return (t1.`val` == t2.`val`)
                    && isMirror(t1.left, t2.right)
                    && isMirror(t1.right, t2.left)
        }

        return isMirror(root.left, root.right)
    }
}

fun main() {
    // Создаём дерево:
    //       1
    //      / \
    //     2   2
    //    / \ / \
    //   3  4 4  3

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)

    val checker = SymmetricTreeChecker()
    println("Симметрично ли дерево? ${checker.isSymmetric(root)}") // true
}