package org.example.Lists

fun main() {
    // Пример: l1 = [2,4,3], l2 = [5,6,4]
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }

    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val solution = AddTwoNumbersNodeList()
    val result = solution.addTwoNumbers(l1, l2)

    printList(result) // Ожидаемый вывод: 7 -> 0 -> 8
}

// Печать связанного списка
fun printList(node: ListNode?) {
    var current = node
    while (current != null) {
        print(current.`val`)
        if (current.next != null) print(" -> ")
        current = current.next
    }
    println()
}


/*
Тебе даны два непустых связных списка, представляющих два неотрицательных числа.
Цифры хранятся в обратном порядке, и каждый узел содержит одну цифру.
Нужно сложить эти два числа и вернуть сумму в виде связного списка.

Можно считать, что оба числа не содержат ведущих нулей, за исключением самого числа 0.

Example 1:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 2:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class AddTwoNumbersNodeList() {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val list1 = listNodeToList(l1)
        val list2 = listNodeToList(l2)

        val num1 = list1.reversed().joinToString("").toBigInteger()
        val num2 = list2.reversed().joinToString("").toBigInteger()

        val sum = num1 + num2
        val sumStr = sum.toString().reversed()

        return intToListNode(sumStr)
    }

    fun intToListNode(numStr: String): ListNode? {
        val dummy = ListNode(0)
        var current = dummy

        for (ch in numStr) {
            current.next = ListNode(ch.digitToInt())
            current = current.next!!
        }

        return dummy.next
    }

    fun listNodeToList(listNode: ListNode?): List<Int> {
        var result = mutableListOf<Int>()
        var current = listNode

        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }

        return result
    }
}