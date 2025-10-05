package org.example.Lists.node

import javax.naming.Context

fun main() {
    // Создаём узлы
    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)

    // Связываем их
    node1.next = node2
    node2.next = node3
    node3.next = node4

    // Создаём цикл: хвост указывает на node2
    node4.next = node2

    // Создаём объекты решений
    val setSolution = LinkedListCycleSetSolution()
    val twoPointersSolution = LinkedListCycleTwoPointersSolution()

    // Проверка через HashSet
    val hasCycleSet = setSolution.hasCycle(node1)
    println("Проверка через HashSet: $hasCycleSet") // Ожидается: true

    // Проверка через два указателя
    val hasCycleTwoPointers = twoPointersSolution.hasCycle(node1)
    println("Проверка через два указателя: $hasCycleTwoPointers") // Ожидается: true

    // Пример списка без цикла
    val nodeA = ListNode(1)
    val nodeB = ListNode(2)
    nodeA.next = nodeB

    println("Без цикла через HashSet: ${setSolution.hasCycle(nodeA)}") // false
    println("Без цикла через два указателя: ${twoPointersSolution.hasCycle(nodeA)}") // false
}

// Решение 1: Проверка цикла через HashSet
class LinkedListCycleSetSolution {
    fun hasCycle(head: ListNode?): Boolean {
        val visitedNodes = mutableSetOf<ListNode>()
        var current = head
        while (current != null) {
            if (current in visitedNodes) return true
            visitedNodes.add(current)
            current = current.next
        }
        return false
    }
}

// Решение 2: Проверка цикла через два указателя (Floyd’s Cycle Detection)
class LinkedListCycleTwoPointersSolution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var slow: ListNode? = head
        var fast: ListNode? = head.next
        while (fast != null) {
            if (slow === fast) return true
            slow = slow?.next
            fast = fast.next?.next
        }
        return false
    }
}
