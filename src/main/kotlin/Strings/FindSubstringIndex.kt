package org.example.Strings

//Даны две строки — needle и haystack.
//Требуется вернуть индекс первого вхождения подстроки needle в строку haystack.
//Если needle не является подстрокой haystack, нужно вернуть -1.
//
//Вход: haystack = "sadbutsad", needle = "sad"
//Выход: 0
//Объяснение: "sad" встречается в строке дважды — на индексах 0 и 6.
//Первое вхождение — на индексе 0, поэтому возвращаем 0.
//
//
//Вход: haystack = "leetcode", needle = "leeto"
//Выход: -1
//Объяснение: "leeto" не встречается в "leetcode", поэтому возвращаем -1.


class SubstringSearchNaive {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.length > haystack.length) return -1
        val limit = haystack.length - needle.length

        loop@ for (i in 0..limit) {
            for (j in 0 until needle.length) {
                if (needle[j] != haystack[i + j]) {
                    continue@loop
                }
            }
            return i
        }

        return -1
    }
}

fun main() {
    val solution = SubstringSearchNaive()
    val result = solution.strStr("sadbutsad", "sad")
    println("Результат: $result") // Ожидается: 0

    val solution1 = SubstringSearchFast()
    val result1 = solution1.strStr("sadbutsad", "sad")
    println("Результат: $result1") // Ожидается: 0
}

class SubstringSearchFast {
    fun strStr(haystack: String, needle: String): Int =
        haystack.indexOf(needle)
}
