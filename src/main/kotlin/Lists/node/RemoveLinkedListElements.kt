package org.example.Lists.node

/**
 * Задача: удалить все элементы из односвязного списка, равные заданному значению.
 *
 * Definition for singly-linked list.
 */

class RemoveElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return head
        head.next = removeElements(head.next, `val`)
        return if (head.`val` == `val`) head.next else head
    }
}

fun main() {
    // Создаём список: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(6)
    head.next!!.next!!.next = ListNode(3)
    head.next!!.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next!!.next = ListNode(6)

    val solver = RemoveElements()
    val newHead = solver.removeElements(head, 6)

    // Выводим результат
    var current = newHead
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
}
