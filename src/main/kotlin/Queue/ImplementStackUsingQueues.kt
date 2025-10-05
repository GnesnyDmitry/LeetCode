package org.example.Queue

/**
 * Задача: Реализовать стек (LIFO) с помощью двух очередей (FIFO).
 *
 * Стек должен поддерживать методы:
 * 1. push(x)  - добавить элемент x на вершину стека
 * 2. pop()    - удалить и вернуть верхний элемент
 * 3. top()    - вернуть верхний элемент без удаления
 * 4. empty()  - проверить, пустой ли стек
 *
 * Ограничения: использовать можно только стандартные операции очереди:
 * - добавление в конец (add / offer)
 * - удаление с начала (removeFirst / poll)
 * - просмотр первого элемента (first / peek)
 * - проверка пустоты (isEmpty) и размер (size)
 */

class MyStack() {

    // Основная очередь, хранит элементы стека
    private val q1: ArrayDeque<Int> = ArrayDeque()
    // Вспомогательная очередь для перестановки элементов
    private val q2: ArrayDeque<Int> = ArrayDeque()

    // Добавление элемента в стек
    fun push(x: Int) {
        q2.add(x) // кладём новый элемент во вспомогательную очередь
        // Перекладываем все элементы из q1 в q2
        while (q1.isNotEmpty()) {
            q2.add(q1.removeFirst())
        }
        // Меняем роли: q2 становится основной очередью
        q1.clear()
        q1.addAll(q2)
        q2.clear()
    }

    // Удаляем верхний элемент стека и возвращаем его
    fun pop(): Int {
        return q1.removeFirst()
    }

    // Возвращаем верхний элемент стека без удаления
    fun top(): Int {
        return q1.first()
    }

    // Проверка, пустой ли стек
    fun empty(): Boolean {
        return q1.isEmpty()
    }
}

// -------------------------
// Пример использования
fun main() {
    val myStack = MyStack()
    myStack.push(1)
    myStack.push(2)
    println("Top element: ${myStack.top()}")   // 2
    println("Pop element: ${myStack.pop()}")   // 2
    println("Is stack empty? ${myStack.empty()}") // false
    println("Pop element: ${myStack.pop()}")   // 1
    println("Is stack empty? ${myStack.empty()}") // true
}
