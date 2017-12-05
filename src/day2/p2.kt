package day2

import java.io.File

fun main(args: Array<String>) {
    var sum = 0

    File("src/day2/input").forEachLine { line ->
        val parts = line.split("\t").map { s -> s.toInt() }
        parts.forEachIndexed { index, i ->
            parts.forEachIndexed { index2, i2 ->
                if (index != index2) {
                    if (i % i2 == 0) {
                        sum += i / i2
                    }
                }
            }
        }
    }

    println(sum)
}