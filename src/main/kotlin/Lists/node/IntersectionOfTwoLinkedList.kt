package org.example.Lists.node

/**
 * Задача:
 * Даны головы двух односвязных списков headA и headB.
 * Нужно вернуть узел, в котором списки пересекаются.
 * Если пересечения нет — вернуть null.
 *
 * Важно:
 * - Узлы сравниваются по ссылке (один и тот же объект в памяти).
 * - Списки не содержат циклов.
 * - Нельзя изменять структуру списков.
 *
 * Пример:
 * A: a1 → a2
 *             \
 *              c1 → c2 → c3
 *             /
 * B: b1 → b2
 *
 * Ответ: c1
 */

class IntersectionSolution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var currentA = headA
        var currentB = headB

        while (currentA !== currentB) {
            currentA = if (currentA == null) headB else currentA.next
            currentB = if (currentB == null) headA else currentB.next
        }

        return currentA
    }
}

// Пример использования
fun main() {
    val common = ListNode(8).apply {
        next = ListNode(10)
    }

    val headA = ListNode(3).apply {
        next = ListNode(7).apply {
            next = common
        }
    }// Стандартная структура узла списка

    val headB = ListNode(99).apply {
        next = ListNode(1).apply {
            next = common
        }
    }

    val solution = IntersectionSolution()
    val result = solution.getIntersectionNode(headA, headB)
    println(result?.`val`) // Ожидается: 8
}
