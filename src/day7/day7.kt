package day7

import java.io.File

fun main(args: Array<String>) {
    p1(File("src/day7/input"))
    p2(File("src/day7/input"))
}

fun p1(file: File) {
    val programs = mutableListOf<String>()
    val subPrograms = mutableListOf<String>()

    file.forEachLine { line ->
        val parts = line.split(" ")

        val program = parts[0]
        programs.add(program)
        val weight = parts[1].trim('(', ')').toInt()

        if ("->" in parts) {
            parts.subList(3, parts.size)
                    .map { it -> it.trim(',') }
                    .forEach { s -> subPrograms.add(s) }
        }
    }

    programs.forEach { program ->
        if (!subPrograms.contains(program)) {
            println(program)
        }
    }
}

val programWeights = mutableMapOf<String, Int>()
val directSubs = mutableMapOf<String, List<String>>()
fun p2(file: File) {
    val programs = mutableListOf<String>()
    val subPrograms = mutableListOf<String>()

    file.forEachLine { line ->
        val parts = line.split(" ")

        val program = parts[0]
        programs.add(program)
        val weight = parts[1].trim('(', ')').toInt()
        programWeights.put(program, weight)

        if ("->" in parts) {
            val subs = parts.subList(3, parts.size)
                    .map { it -> it.trim(',') }
            subs.forEach { s -> subPrograms.add(s) }

            directSubs.put(program, subs)
        }
    }

    val programTotalWeights = mutableMapOf<String, Int>()
    for (p: String in programs) {
        if (directSubs.containsKey(p)) {
           programTotalWeights.put(p, getWeightOfProgramAndSubs(p))
        } else {
            programTotalWeights.put(p, programWeights[p]!!)
        }
    }

    for (p: String in programs.filter { directSubs.containsKey(it) }) {

        val weights = directSubs[p]!!.map { programTotalWeights[it]!! }
        if (weights.toSet().size != 1) {
            println(programTotalWeights[p])
            println(weights)
            directSubs[p]!!.forEach { t: String? -> print("${programWeights[t]} - ") }
            println()
            println(programWeights[p])
            println()
        }
    }
}

fun getWeightOfProgramAndSubs(name: String): Int {
    var weight = 0
    weight += programWeights[name]!! // start with weight of the program itself

    // recursively add weights of sub programs
    if (directSubs.containsKey(name)) {
        for (sub: String in directSubs[name]!!) {
            weight += getWeightOfProgramAndSubs(sub)
        }
    }

    return weight
}
