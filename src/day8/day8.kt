package day8

import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/day8/input").readLines()
    p1(lines)
    p2(lines)
}

fun p1(lines: List<String>) {
    val values = mutableMapOf<String, Int>()

    for (line in lines) {
        values.put(line.split(" ")[0], 0)
    }

    for (line in lines) {
        val parts = line.split(" ")

        val subject = parts[0]
        val operator = parts[1]
        val n = parts[2].toInt()
        val condition = parts.subList(4, parts.size)

        if (checkCondition(condition, values)) {
            val currentValue = values[subject]!!

            if (operator == "inc") {
                values[subject] = currentValue + n
            } else if (operator == "dec") {
                values[subject] = currentValue - n
            }
        }
    }

    println(values.values.max())
}

fun p2(lines: List<String>) {
    val values = mutableMapOf<String, Int>()
    var max = 0;

    for (line in lines) {
        values.put(line.split(" ")[0], 0)
    }

    for (line in lines) {
        val parts = line.split(" ")

        val subject = parts[0]
        val operator = parts[1]
        val n = parts[2].toInt()
        val condition = parts.subList(4, parts.size)

        if (checkCondition(condition, values)) {
            val currentValue = values[subject]!!

            if (operator == "inc") {
                values[subject] = currentValue + n
            } else if (operator == "dec") {
                values[subject] = currentValue - n
            }
            if (values[subject]!! > max) {
                max = values[subject]!!
            }
        }
    }

    println(max)
}

fun checkCondition(condition: List<String>, values: Map<String, Int>): Boolean {
    val a = values[condition[0]]!!.toInt()
    val b = condition[2].toInt()

    return when (condition[1]) {
        "==" -> a == b
        "!=" -> a != b
        ">" -> a > b
        "<" -> a < b
        ">=" -> a >= b
        "<=" -> a <= b
        else -> false
    }
}