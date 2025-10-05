package org.example.Lists

/**
 * Класс для вычисления максимальной прибыли от покупки и продажи акций.
 *
 * Алгоритм:
 * - сохраняем минимальную цену покупки (buy),
 * - обновляем максимальную цену продажи (sell),
 * - вычисляем разницу (прибыль),
 * - выбираем наибольшую.
 *
 * Вход: массив цен за каждый день.
 * Выход: максимальная возможная прибыль.
 *
 * Пример:
 * prices = [7,1,5,3,6,4] → результат = 5 (покупаем за 1, продаём за 6).
 */
class StockProfitCalculator {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var sell = 0
        var result = 0

        for (i in 1 until prices.size) {
            if (prices[i] < buy) {
                buy = prices[i]
                sell = prices[i]
            }
            if (prices[i] > sell) sell = prices[i]

            if (sell - buy > result) result = sell - buy
        }
        return result
    }
}

fun main() {
    val calculator = StockProfitCalculator()
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println("Максимальная прибыль: ${calculator.maxProfit(prices)}")
}
