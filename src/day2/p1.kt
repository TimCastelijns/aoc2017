package day2

import java.io.File

fun main(args: Array<String>) {
    var sum = 0

    File("src/day2/input").forEachLine { line ->
        val parts = line.split("\t").map { s -> s.toInt() }
        val min = parts.min()
        val max = parts.max()
        sum += max!! - min!!
    }

    println(sum)
}
