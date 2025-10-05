package org.example

/**
 * Задача: "Подъём по лестнице"
 *
 * Условие:
 * Вы поднимаетесь по лестнице, которая состоит из n ступенек.
 * Каждый раз вы можете подняться на 1 или 2 ступеньки.
 * Нужно посчитать, сколькими **разными способами** можно подняться на вершину.
 *
 * Пример:
 * Input: n = 4
 * Output: 5
 * Объяснение: 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2
 */

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        var f0 = 0    // f(n-2)
        var f1 = 1    // f(n-1)
        var fResult = 0

        for (i in 1..n) {
            fResult = f1 + f0
            f0 = f1
            f1 = fResult
        }

        return f1
    }
}

// Тестируем решение
fun main() {
    val solution = ClimbingStairs()

    val n = 4
    println("Количество способов подняться на $n ступенек: ${solution.climbStairs(n)}")

    val n2 = 7
    println("Количество способов подняться на $n2 ступенек: ${solution.climbStairs(n2)}")
}
