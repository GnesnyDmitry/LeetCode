package org.example.Lists.node

/**
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ReversedLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val next = current.next   // сохранили ссылку
            current.next = prev       // развернули
            prev = current            // сдвинули prev
            current = next            // идём дальше
        }

        return prev
    }
}

fun main() {
    // создаём список 1 -> 2 -> 3 -> 4 -> 5
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    val solution = ReversedLinkedList()
    val reversed = solution.reverseList(head)

    // печать списка после разворота
    var node = reversed
    while (node != null) {
        print("${node.`val`} ")
        node = node.next
    }
    // вывод: 5 4 3 2 1
}
