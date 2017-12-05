package day3

enum class Direction { RIGHT, UP, LEFT, DOWN }

var n = 100
val grid = Array(n) { Array(n, { "" }) }

fun surroundingsSum(x: Int, y: Int): Int {
    var sum = 0

    if (y > 0 && x > 0) {
        if (grid[y - 1][x - 1] != "") {
            val add = grid[y - 1][x - 1].trim().toInt()
            sum += add
        }
    }
    if (y > 0 && x <= n - 1) {
        if (grid[y - 1][x] != "") {
            val add = grid[y - 1][x].trim().toInt()
            sum += add
        }
    }
    if (y > 0 && x < n - 1) {
        if (grid[y - 1][x + 1] != "") {
            val add = grid[y - 1][x + 1].trim().toInt()
            sum += add
        }
    }
    if (x > 0 && y <= n - 1) {
        if (grid[y][x - 1] != "") {
            val add = grid[y][x - 1].trim().toInt()
            sum += add
        }
    }
    if (x < n - 1 && y <= n - 1) {
        if (grid[y][x + 1] != "") {
            val add = grid[y][x + 1].trim().toInt()
            sum += add
        }
    }
    if (y < n - 1 && x > 0) {
        if (grid[y + 1][x - 1] != "") {
            val add = grid[y + 1][x - 1].trim().toInt()
            sum += add
        }
    }
    if (x <= n - 1 && y < n - 1) {
        if (grid[y + 1][x] != "") {
            val add = grid[y + 1][x].trim().toInt()
            sum += add
        }
    }
    if (y < n - 1 && x < n - 1) {
        if (grid[y + 1][x + 1] != "") {
            val add = grid[y + 1][x + 1].trim().toInt()
            sum += add
        }
    }

    return sum
}

fun main(args: Array<String>) {
    var dir = Direction.RIGHT

    var y = n / 2
    var x = if (n % 2 == 0) y - 1 else y

    var iteration = 0;
    for (j in 1..n * n - 1 + 1) {
        iteration++;
        if (iteration == 1) {
            grid[y][x] = "1"
        } else {
            val s = surroundingsSum(x, y)
            if (s > 265149) {
                println(s)
                break
            }
            grid[y][x] = "%d".format(s)
        }

        when (dir) {
            Direction.RIGHT -> if (x <= n - 1 && grid[y - 1][x].none() && j > 1) dir = Direction.UP
            Direction.UP -> if (grid[y][x - 1].none()) dir = Direction.LEFT
            Direction.LEFT -> if (x == 0 || grid[y + 1][x].none()) dir = Direction.DOWN
            Direction.DOWN -> if (grid[y][x + 1].none()) dir = Direction.RIGHT
        }

        when (dir) {
            Direction.RIGHT -> x++
            Direction.UP -> y--
            Direction.LEFT -> x--
            Direction.DOWN -> y++
        }
    }

    for (row in grid) println(row.joinToString("") { s -> "[%6d]".format(s.toInt()) })
    println()
}

