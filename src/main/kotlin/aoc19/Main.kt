package aoc19


val solutionTable = mapOf(
    "1" to day01
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