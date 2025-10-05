package org.example.Tree

/**
 * Задача: Проверить, одинаковы ли два бинарных дерева.
 *
 * Условия:
 * - Даны два бинарных дерева `p` и `q`.
 * - Нужно вернуть `true`, если деревья идентичны по структуре и значениям узлов.
 * - Иначе вернуть `false`.
 *
 * Пример 1:
 * Input:
 *      Tree p:    1
 *                / \
 *               2   3
 *
 *      Tree q:    1
 *                / \
 *               2   3
 * Output: true
 *
 * Пример 2:
 * Input:
 *      Tree p:    1
 *                /
 *               2
 *
 *      Tree q:    1
 *                  \
 *                   2
 * Output: false
 */

/**
 * Определение узла бинарного дерева
 */

/**
 * Класс решения
 */
class BinaryTreeComparator {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        // Оба узла пустые → одинаковы
        if (p == null && q == null) return true

        // Один узел пустой → деревья разные
        if (p == null || q == null) return false

        // Значения узлов совпадают и рекурсивно левое и правое поддерево тоже одинаковы
        return (p.`val` == q.`val`) &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right)
    }
}

/**
 * Пример использования:
 */
fun main() {
    val p = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    val q = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }

    val comparator = BinaryTreeComparator()
    println(comparator.isSameTree(p, q)) // true
}
