package tests

import io.kotlintest.*
import io.kotlintest.specs.*
import io.kotlintest.data.*
import io.kotlintest.tables.*

import aoc19.*


class Aoc19Tests : StringSpec({
    "day 1" {
        forall(
            row("12", "2"),
            row("14", "2"),
            row("1969", "654"),
            row("100756", "33583")
        ) { input, output ->
            day01(input) shouldBe output
        }
    }
})