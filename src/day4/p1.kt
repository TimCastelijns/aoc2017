package day4

import java.io.File

fun main(args: Array<String>) {
    var sum = 0

    File("src/day4/input").forEachLine { line ->
        val parts = line.split(" ")
        if (parts.distinct().size == parts.size) {
            sum++
        }
    }

    println(sum)
}
