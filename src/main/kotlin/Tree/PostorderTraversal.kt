package org.example.Tree

/**
 * Задача: Реализовать обход бинарного дерева в порядке postorder (лево → право → корень).
 *
 * Определение:
 * - TreeNode — узел бинарного дерева.
 * - Функция должна возвращать список значений в postorder порядке.
 *
 * Пример:
 * Вход:
 *      1
 *       \
 *        2
 *       /
 *      3
 *
 * Выход: [3, 2, 1]
 */

/**
 * Решение 1 (рекурсия + глобальный список)
 */
class SolutionRecursiveList {
    private val orderTraversalList = mutableListOf<Int>()

    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root != null) {
            postorderTraversal(root.left)
            postorderTraversal(root.right)
            orderTraversalList.add(root.`val`)
        }
        return orderTraversalList
    }
}

/**
 * Решение 2 (рекурсия + конкатенация списков)
 */
class SolutionRecursiveConcat {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()

        val result = postorderTraversal(root.left) +
                postorderTraversal(root.right) +
                listOf(root.`val`)

        return result
    }
}

/**
 * Тестовый запуск
 */
fun main() {
    // Пример дерева:
    //      1
    //       \
    //        2
    //       /
    //      3
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)

    val sol1 = SolutionRecursiveList()
    println("Решение 1: " + sol1.postorderTraversal(root)) // [3, 2, 1]

    val sol2 = SolutionRecursiveConcat()
    println("Решение 2: " + sol2.postorderTraversal(root)) // [3, 2, 1]
}
