package org.example

//Given an integer x, return true if x is a palindrome, and false otherwise.

fun main() {
    val solution = SolutionPolindrome()

    val testCases = listOf(121, -121, 10, 12321, 0, 1463847412)

    for (x in testCases) {
        println("x = $x => isPalindrome = ${solution.isPalindrome(x)}")
    }
}

class SolutionPolindrome() {
    fun isPalindrome(x: Int): Boolean =
        x >= 0 && x.toString() == x.toString().reversed()
}
