package org.example.Lists.node

import org.example.Lists.ListNode

/**
 * Задача: "Удаление дубликатов из отсортированного списка"
 *
 * Условие:
 * Дана отсортированная однонаправленная цепочка ListNode.
 * Нужно удалить все дубликаты, чтобы каждый элемент встречался только один раз.
 *
 * Пример 1:
 * Input: 1 -> 1 -> 2
 * Output: 1 -> 2
 *
 * Пример 2:
 * Input: 1 -> 1 -> 2 -> 3 -> 3
 * Output: 1 -> 2 -> 3
 */

// Определение узла списка
class ListNode1(var `val`: Int) {
    var next: ListNode? = null
}

// Новый класс решения
class RemoveDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var current = head
        var nextNode = head.next

        while (nextNode != null) {
            if (current?.`val` == nextNode.`val`) {
                // Пропускаем дубликат
                current?.next = nextNode.next
                nextNode.next = null
                nextNode = current.next
            } else {
                current = current?.next
                nextNode = nextNode.next
            }
        }

        return head
    }
}

// Тестирование функции
fun main() {
    // Создание списка: 1 -> 1 -> 2 -> 3 -> 3
    val head = ListNode(1)
    head.next = ListNode(1)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(3)
    head.next?.next?.next?.next = ListNode(3)

    val solution = RemoveDuplicates()
    val newHead = solution.deleteDuplicates(head)

    // Вывод списка после удаления дубликатов
    var node = newHead
    while (node != null) {
        print("${node.`val`} ")
        node = node.next
    }
    // Вывод: 1 2 3
}
