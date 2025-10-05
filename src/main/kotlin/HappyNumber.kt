package org.example

/**
 * Задача: Определить, является ли число "счастливым".
 *
 * Счастливое число определяется так:
 * 1. Начинаем с любого положительного числа n.
 * 2. Заменяем число на сумму квадратов его цифр.
 * 3. Повторяем процесс, пока число не станет равно 1 (тогда оно счастливое),
 *    либо не начнёт зацикливаться (тогда оно несчастливое).
 *
 * Пример:
 * n = 19
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1 → счастливое число
 */

class HappyNumberDemo {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = n

        // Алгоритм Флойда ("черепаха и заяц")
        do {
            slow = nextNumber(slow)             // один шаг
            fast = nextNumber(nextNumber(fast)) // два шага
        } while (slow != fast)

        return slow == 1
    }

    // Вычисляет сумму квадратов цифр числа
    private fun nextNumber(num: Int): Int {
        var n = num
        var sum = 0
        while (n > 0) {
            val digit = n % 10
            sum += digit * digit
            n /= 10
        }
        return sum
    }
}

// Точка входа
fun main() {
    val solution = HappyNumberDemo()
    println("19 счастливое? ${solution.isHappy(19)}") // true
    println("2 счастливое? ${solution.isHappy(2)}")   // false
}
