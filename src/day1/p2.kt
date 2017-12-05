package day1

val inputLength = input.length
val indexOffset = inputLength / 2

fun main(args: Array<String>) {
    var sum = 0

    for ((index, char) in input.withIndex()) {
        val a = char.toString().toInt()
        val b = input[compareIndex(index)].toString().toInt()

        if (a == b) {
            sum += a
        }
    }

    println(sum)
}

fun compareIndex(currentIndex: Int) : Int {
    val x = currentIndex + indexOffset
    return if (x >= inputLength) {
        x - inputLength
    } else {
        x
    }
}
