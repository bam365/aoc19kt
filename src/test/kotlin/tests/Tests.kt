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

    "day 2" {
        forall(
            row("1,9,10,3,2,3,11,0,99,30,40,50", 3500),
            row("1,1,1,4,99,5,6,0,99", 30)
        ) { input, output ->
            runProgram(Program(parseCodes(input)), 0).readPosition(0) shouldBe output
        }
    }
})