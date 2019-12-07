package tests

import io.kotlintest.*
import io.kotlintest.specs.*
import io.kotlintest.data.*
import io.kotlintest.tables.*

import aoc19.*
import aoc19.day03.day03


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

    "day 3" {
        forall(
            row("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83", "159"),
            row("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7", "135")
        ) { input, output ->
            day03(input) shouldBe output
        }
    }
})