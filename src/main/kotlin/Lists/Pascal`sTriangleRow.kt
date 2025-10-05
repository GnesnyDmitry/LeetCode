package org.example.Lists

/**
 * Класс для генерации конкретной строки треугольника Паскаля по индексу.
 * Пример:
 * rowIndex = 4 -> [1, 4, 6, 4, 1]
 */
class PascalTriangleRow {

    fun getRow(rowIndex: Int): List<Int> {
        val result = mutableListOf(1) // Начальная строка треугольника

        if (rowIndex == 0) return result // Если нужна 0-я строка, возвращаем [1]

        for (i in 1..rowIndex) {
            result.add(1) // Добавляем 1 в конец строки

            // Обновляем внутренние элементы с конца к началу
            for (j in i - 1 downTo 1) {
                result[j] = result[j] + result[j - 1]
            }
        }
        return result
    }
}

// Пример запуска
fun main() {
    val solution = PascalTriangleRow()
    val rowIndex = 4
    val row = solution.getRow(rowIndex)
    println("Строка $rowIndex треугольника Паскаля: $row")
}
