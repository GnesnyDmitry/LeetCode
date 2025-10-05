package org.example.Tree

import java.util.LinkedList
import java.util.Queue

/**
 * Класс BinaryTree содержит методы для вычисления максимальной глубины дерева.
 */
class BinaryTree {

    /**
     * Вариант 1. Рекурсивное решение.
     * Для каждого узла вычисляем глубину его поддеревьев
     * и берём максимум. Базовый случай — null (глубина 0).
     */
    fun maxDepthRecursive(root: TreeNode?): Int {
        var depth = 0
        if (root != null) {
            depth += (maxOf(maxDepthRecursive(root.left), maxDepthRecursive(root.right))) + 1
        }
        return depth
    }

    /**
     * Вариант 2. Итеративное решение через очередь (BFS).
     * Идём по уровням. Каждый уровень увеличивает глубину на 1.
     */
    fun maxDepthBFS(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var height = 0

        while (queue.isNotEmpty()) {
            val lvlSize = queue.size
            repeat(lvlSize) {
                val node = queue.poll()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            height++
        }
        return height
    }
}

/**
 * Тестовый запуск в IDEA.
 */
fun main() {
    // создаём дерево:
    //       1
    //      / \
    //     2   3
    //    /
    //   4
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }

    val tree = BinaryTree()

    println("Глубина дерева (рекурсия): ${tree.maxDepthRecursive(root)}")
    println("Глубина дерева (BFS): ${tree.maxDepthBFS(root)}")
}
