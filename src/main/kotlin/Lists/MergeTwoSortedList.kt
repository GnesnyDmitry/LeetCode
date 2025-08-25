package org.example.Lists


//Даны головы двух отсортированных связанных списков list1 и list2.
//
//Требуется объединить эти два списка в один отсортированный связанный список, соединяя (сплайся) узлы из двух исходных списков.
//
//Верни голову объединённого отсортированного списка.
//
//Примеры:
//
//Пример 1:
//
//Вход: list1 = [1,2,4], list2 = [1,3,4]
//Выход: [1,1,2,3,4,4]
//
//Пример 2:
//
//Вход: list1 = [], list2 = []
//Выход: []
//
//Пример 3:
//
//Вход: list1 = [], list2 = [0]
//Выход: [0]

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//class MergeTwoSortedList1 {
//    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//        if (list1 == null && list2 != null) return list2
//        if (list2 == null && list1 != null) return list1
//        if (list2 == null && list1 == null) return null
//
//        var p1 = list1
//        var p2 = list2
//
//        val temp = ListNode(0)
//        var curr = temp
//
//        while (p1 != null && p2 != null) {
//            if (p1.`val` < p2.`val`) {
//                curr.next = ListNode(p1.`val`)
//                p1 = p1.next
//            }
//            else {
//                curr.next = ListNode(p2.`val`)
//                p2 = p2.next
//            }
//            curr = curr.next
//        }
//        curr.next = p1 ?: p2
//        return temp.next
//    }
//}

class MergeTwoSortedList2 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var current = list1
        val resultList = mutableListOf<Int>()
        while (current != null) {
            resultList.add(current.`val`)
            current = current.next
        }

        current = list2
        while (current != null) {
            resultList.add(current.`val`)
            current = current.next
        }

        resultList.sort()

        if (resultList.isEmpty()) return null

        val head = ListNode(resultList[0])
        var node = head
        for (i in 1 until resultList.size) {
            node.next = ListNode(resultList[i])
            node = node.next!!
        }

        return head
    }
}

fun main() {

    fun printList(head: ListNode?) {
        var curr = head
        while (curr != null) {
            print("${curr.`val`} ")
            curr = curr.next
        }
        println()
    }

    // Создаём list1: 1 -> 2 -> 4
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next!!.next = ListNode(4)

    // Создаём list2: 1 -> 3 -> 4
    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)

    val solution = MergeTwoSortedList2()
    val merged = solution.mergeTwoLists(list1, list2)

    printList(merged)  // Выведет: 1 1 2 3 4 4
}
