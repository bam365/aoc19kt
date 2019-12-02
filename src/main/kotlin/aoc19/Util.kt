package aoc19


fun intSolution(fn: (Int) -> Int) = { input: String ->
        fn(input.toInt()).toString()
}

fun intsSolution(fn: (Iterable<Int>) -> Int) = { input: String ->
        fn(input.lines().map { it.toInt() }).toString()
}