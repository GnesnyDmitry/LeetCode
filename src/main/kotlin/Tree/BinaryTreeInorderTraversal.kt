package org.example.Tree

/**
 * Задача: Дано бинарное дерево. Нужно вернуть значения его узлов в порядке
 * inorder-траверса (левое поддерево → узел → правое поддерево).
 *
 * Пример дерева:
 *       1
 *      / \
 *     2   3
 * Вызов inorderTraversal(root) вернёт [2,1,3].
 */

/**
 * Определение узла бинарного дерева
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Класс с функцией inorder-траверса
 */
class BinaryTreeInorder {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        return inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }
}

/**
 * Пример использования
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    val solver = BinaryTreeInorder()
    val result = solver.inorderTraversal(root)
    println(result)  // Вывод: [2, 1, 3]
}
