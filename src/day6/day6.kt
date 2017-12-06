package day6

val input = "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4"
val banks = input.split("\t").map { it -> it.toInt() }.toMutableList()
var currentState = banks

var states = mutableListOf<String>()
var cycles = 0
val elements = banks.size

fun main(args: Array<String>) {
    p1()
    p2()
}

fun p1() {
    while (true) {
        cycles++

        var indexMax = 0
        var valueMax = 0
        currentState.forEachIndexed { index, i ->
            if (i > valueMax) {
                valueMax = i
                indexMax = index
            }
        }

        val newState = redistribute(valueMax, indexMax)

        if (states.contains(newState)) {
            break
        }

        states.add(newState)
    }

    println(cycles)
}

fun p2() {
    while (true) {
        cycles++

        var indexMax = 0
        var valueMax = 0
        currentState.forEachIndexed { index, i ->
            if (i > valueMax) {
                valueMax = i
                indexMax = index
            }
        }

        val newState = redistribute(valueMax, indexMax)

        if (states.contains(newState)) {
            println((cycles - 1) - states.indexOf(newState))
            break
        }

        states.add(newState)
    }
}

fun redistribute(value: Int, index: Int): String {
    currentState[index] = 0

    var currentIndex = index
    var currentValue = value
    while (currentValue > 0) {
        currentIndex++
        if (currentIndex == elements) {
            currentIndex = 0
        }
        currentState[currentIndex] = currentState[currentIndex] + 1
        currentValue--
    }

    return currentState.toString()
}
