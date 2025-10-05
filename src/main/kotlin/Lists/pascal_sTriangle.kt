package org.example.Lists

/**
 * Программа для генерации треугольника Паскаля.
 *
 * Реализовано два подхода:
 * 1. PascalTriangleBuilder — строит список строк поочерёдно, добавляя каждый новый ряд
 *    на основе предыдущего (использует result + nextList).
 * 2. PascalTriangleCompact — сразу создаёт «скелет» из единиц и потом
 *    пересчитывает внутренние элементы (использует triangle[row][column]).
 *
 * В функции main() оба варианта вызываются и выводят результат.
 */

fun main() {
    val generator1 = PascalTriangleBuilder()
    val generator2 = PascalTriangleCompact()

    println("=== Вариант 1 (через result + nextList) ===")
    println(generator1.generate(5))

    println("=== Вариант 2 (через triangle[row][column]) ===")
    println(generator2.generate(5))
}

/**
 * Вариант 1: строим треугольник поэтапно,
 * добавляя каждый новый ряд на основе предыдущего.
 */
class PascalTriangleBuilder {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>(mutableListOf(1))
        if (numRows == 1) {
            return result
        } else {
            val nums2 = mutableListOf(1, 1)
            result.add(nums2)
        }

        for (i in 1 until numRows - 1) {
            val nextList = mutableListOf<Int>()
            val currentList = result[i]

            nextList.add(1) // первый элемент всегда 1
            for (j in 0 until currentList.size - 1) {
                nextList.add(currentList[j] + currentList[j + 1])
            }
            nextList.add(1) // последний элемент всегда 1

            result.add(nextList)
        }
        return result
    }
}

/**
 * Вариант 2: создаём сразу список из единиц,
 * потом пересчитываем внутренние элементы.
 */
class PascalTriangleCompact {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = MutableList(numRows) { MutableList(it + 1) { 1 } }
        for (row in 2 until numRows) {
            for (column in 1 until row) {
                triangle[row][column] =
                    triangle[row - 1][column - 1] + triangle[row - 1][column]
            }
        }
        return triangle
    }
}
