package day3

import kotlin.math.ceil
import kotlin.math.sqrt

val input = "265149"

/*
 *  Modified from https://rosettacode.org/wiki/Ulam_spiral_(for_primes)#Kotlin
 */
object Ulam {
    fun generate(n: Int, i: Int = 1) {
        require(n > 1)

        val s = Array(n) { Array(n, { "" }) }
        var dir = Direction.RIGHT
        var y = n / 2
        var x = if (n % 2 == 0) y - 1 else y // shift left for even n's

        for (j in i..n * n - 1 + i) {

            if (j == 1) {
                println("found 1 at")
                println(y)
                println(x)
            } else if (j == 265149) {
                println("found 265149 at")
                println(y)
                println(x)
                break
            }

            s[y][x] = "%d".format(j)

            when (dir) {
                Direction.RIGHT -> if (x <= n - 1 && s[y - 1][x].none() && j > i) dir = Direction.UP
                Direction.UP -> if (s[y][x - 1].none()) dir = Direction.LEFT
                Direction.LEFT -> if (x == 0 || s[y + 1][x].none()) dir = Direction.DOWN
                Direction.DOWN -> if (s[y][x + 1].none()) dir = Direction.RIGHT
            }

            when (dir) {
                Direction.RIGHT -> x++
                Direction.UP -> y--
                Direction.LEFT -> x--
                Direction.DOWN -> y++
            }
        }
    }

    private enum class Direction { RIGHT, UP, LEFT, DOWN }
}

fun main(args: Array<String>) {
    Ulam.generate(ceil(sqrt(265149.toDouble())).toInt())
}