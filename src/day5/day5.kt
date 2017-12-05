package day5

import java.io.File

fun main(args: Array<String>) {
    val file = File("src/day5/input")

    p1(file)
    p2(file)
}

fun p1(file: File) {
    val nrLines = file.readLines().size

    val instructions = arrayOfNulls<Int>(nrLines)
    file.readLines().forEachIndexed { index, s -> instructions[index] = s.toInt() }

    var pos = 0
    var jumps = 0
    while (pos < nrLines) {
        val step = instructions[pos]
        instructions[pos] = instructions[pos]!!.inc()

        pos += step!!
        jumps++
    }

    println(jumps)
}

fun p2(file: File) {
    val nrLines = file.readLines().size

    val instructions = arrayOfNulls<Int>(nrLines)
    file.readLines().forEachIndexed { index, s -> instructions[index] = s.toInt() }

    var pos = 0
    var jumps = 0
    while (pos < nrLines) {
        val step = instructions[pos]
        if (step!! >= 3) {
            instructions[pos] = instructions[pos]!!.dec()
        } else {
            instructions[pos] = instructions[pos]!!.inc()
        }

        pos += step
        jumps++
    }

    println(jumps)
}
