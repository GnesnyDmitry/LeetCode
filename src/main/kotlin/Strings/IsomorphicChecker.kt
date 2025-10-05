package org.example.Strings

class IsomorphicChecker {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map = mutableMapOf<Char, Char>()
        val used = mutableSetOf<Char>()

        for (i in s.indices) {
            val a = s[i]
            val b = t[i]

            if (map.containsKey(a)) {
                if (map[a] != b) return false
            } else {
                if (b in used) return false
                map[a] = b
                used.add(b)
            }
        }

        return true
    }
}

fun main() {
    val checker = IsomorphicChecker()
    println(checker.isIsomorphic("egg", "add")) // true
    println(checker.isIsomorphic("foo", "bar")) // false
}
