package org.example.Strings

/**
 * Дана строка s, состоящая из слов и пробелов.
 * Нужно вернуть длину последнего слова в строке.
 *
 * Слово — это максимальная подстрока, состоящая только из непробельных символов.
 *
 * Примеры:
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Объяснение: последнее слово — "World", длина 5
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Объяснение: последнее слово — "moon", длина 4
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Объяснение: последнее слово — "joyboy", длина 6
 */

class LastWordLength {
    // Вариант 1: через lastIndexOf
    fun lengthOfLastWord(s: String): Int {
        val trimmed = s.trimEnd()
        return trimmed.length - trimmed.lastIndexOf(' ') - 1
    }

    // Вариант 2: проход с конца строки
    fun lengthOfLastWordLoop(s: String): Int {
        var count = 0
        for (i in s.length - 1 downTo 0) {
            val char = s[i]
            if (char != ' ') {
                count++
            } else {
                if (count > 0) break
            }
        }
        return count
    }
}

fun main() {
    val solution = LastWordLength()

    val test1 = "Hello World"
    val test2 = "   fly me   to   the moon  "
    val test3 = "luffy is still joyboy"

    println("Вариант 1:")
    println("Результат 1: ${solution.lengthOfLastWord(test1)}") // 5
    println("Результат 2: ${solution.lengthOfLastWord(test2)}") // 4
    println("Результат 3: ${solution.lengthOfLastWord(test3)}") // 6

    println("\nВариант 2 (цикл с конца):")
    println("Результат 1: ${solution.lengthOfLastWordLoop(test1)}") // 5
    println("Результат 2: ${solution.lengthOfLastWordLoop(test2)}") // 4
    println("Результат 3: ${solution.lengthOfLastWordLoop(test3)}") // 6
}
