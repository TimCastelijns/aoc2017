package day9

import java.io.File

fun main(args: Array<String>) {
    val line = File("src/day9/input").readLines()[0]
    p1(line)
    p2(line)
}

fun p1(stream: String) {
    var skipNext = false
    var inGarbage = false

    val filteredStream = StringBuilder()

    for (c in stream) {
        if (skipNext) {
            skipNext = false
            continue
        }

        if (c == '!' && inGarbage) {
            skipNext = true
            continue
        }

        if (!inGarbage && c != '<' && c != ',') {
            filteredStream.append(c)
        }

        if (!inGarbage) {
            if (c == '<') {
                inGarbage = true
            }
        } else if (c == '>') {
            inGarbage = false
        }
    }

    var depth = 0
    var score = 0
    for (c in filteredStream) {
        if (c == '{') {
            depth++
        } else if (c == '}') {
            score += depth
            depth--
        }
    }

    println("$score")
}

fun p2(stream: String) {
    var skipNext = false
    var inGarbage = false

    val filteredStream = StringBuilder()
    var nonCancelled = 0

    for (c in stream) {
        if (skipNext) {
            skipNext = false
            continue
        }

        if (c == '!' && inGarbage) {
            skipNext = true
            continue
        }

        if (!inGarbage && c != '<' && c != ',') {
            filteredStream.append(c)
        }

        if (!inGarbage) {
            if (c == '<') {
                inGarbage = true
            }
        } else if (c == '>') {
            inGarbage = false
        } else {
            nonCancelled++
        }
    }

    println(nonCancelled)
}
