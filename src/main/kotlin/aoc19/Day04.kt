package aoc19


fun hasDouble(s: String): Boolean {
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            return true
        }
    }
    return false
}

fun isAscending(s: String): Boolean {
    for (i in 1 until s.length) {
        if (s[i].toInt() < s[i-1].toInt()) {
            return false
        }
    }
    return true
}

fun numberMeetsQualifications(n: Int): Boolean =
    n.toString().let { hasDouble(it) && isAscending(it) }


fun day04(input: String): String {
    val range = input.split("-")
    val answer = IntRange(range[0].toInt(), range[1].toInt()).count(::numberMeetsQualifications)
    return answer.toString()
}

