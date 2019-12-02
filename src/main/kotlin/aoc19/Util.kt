package aoc19


fun intSolution(fn: (Int) -> Int) = { input: String ->
        fn(input.toInt()).toString()
}

fun intsSolution(fn: (Iterable<Int>) -> Int) = { input: String ->
        input.lines()
            .map { it.toInt() }
            .let(fn)
            .toString()
}