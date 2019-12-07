package aoc19

import aoc19.day03.day03

val solutionTable: Map<String, (String) -> String> = mapOf(
    "1" to day01,
    "2" to ::day02,
    "3" to ::day03,
    "4" to ::day04
)

fun main(args: Array<String>) {
    if (args.count() < 1) {
        println("Need to specify solution")
        return
    }

    val solution = solutionTable[args[0]] ?: error("No such solution")
    val input = generateSequence(::readLine).joinToString("\n")
    println(solution(input))
}