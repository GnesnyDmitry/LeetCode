/**
 * Задача: Проверка, является ли строка палиндромом.
 * Палиндром — это строка, которая читается одинаково слева направо и справа налево,
 * игнорируя пробелы, знаки препинания и регистр букв.
 *
 * Пример:
 * "A man, a plan, a canal: Panama" -> true
 * "race a car" -> false
 */

class PalindromeChecker {

    // Метод 1: через очистку строки и reversed()
    fun isPalindromeCleaned(s: String): Boolean {
        if (s.isEmpty()) return true

        // Убираем все символы, кроме букв и цифр, и приводим к нижнему регистру
        val cleaned = s.replace(Regex("[^A-Za-zА-Яа-я0-9]"), "").lowercase()

        // Сравниваем строку с её перевёрнутой версией
        return cleaned == cleaned.reversed()
    }

    // Метод 2: двухуказательный алгоритм (оптимальный)
    fun isPalindromeTwoPointers(s: String): Boolean {
        val chars = s.lowercase().toCharArray()
        var start = 0
        var end = s.length - 1

        while (start < end) {
            // Пропускаем все символы, которые не буквы и не цифры
            while (start < s.length && chars[start] !in 'a'..'z' && chars[start] !in '0'..'9') {
                start++
            }
            while (end >= 0 && chars[end] !in 'a'..'z' && chars[end] !in '0'..'9') {
                end--
            }

            if (start > end) return true

            if (chars[start] != chars[end]) return false

            start++
            end--
        }
        return true
    }
}

// Пример использования
fun main() {
    val checker = PalindromeChecker()

    val test1 = "A man, a plan, a canal: Panama"
    val test2 = "race a car"

    println(checker.isPalindromeCleaned(test1))      // true
    println(checker.isPalindromeCleaned(test2))      // false

    println(checker.isPalindromeTwoPointers(test1))  // true
    println(checker.isPalindromeTwoPointers(test2))  // false
}
