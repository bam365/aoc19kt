package aoc19


fun day02(input: String): String {
    val program = Program(parseCodes(input)).let(::reset1202ErrorState)
    return runProgram(program, 0).readPosition(0).toString()
}

sealed class Instruction {
    data class Exit(val unit: Unit = Unit) : Instruction()
    data class Add(val op1: Int, val op2: Int, val position: Int) : Instruction()
    data class Mul(val op1: Int, val op2: Int, val position: Int) : Instruction()
}

class Program(private val codes: List<Int>) {
    enum class Opcodes(val code: Int) {
        ADD(1),
        MUL(2),
        EXIT(99),
    }

    fun getNthInstruction(n: Int): Instruction {
        val ip = n * 4
        return when (codes[ip]) {
            Opcodes.ADD.code -> Instruction.Add(codes[ip + 1], codes[ip + 2], codes[ip + 3])
            Opcodes.MUL.code -> Instruction.Mul(codes[ip + 1], codes[ip + 2], codes[ip + 3])
            Opcodes.EXIT.code -> Instruction.Exit()
            else -> throw IllegalStateException("Opcode not supported")
        }
    }

    fun readPosition(n: Int): Int = codes[n]

    fun writePosition(pos: Int, code: Int): Program =
        Program(codes.mapIndexed { i, v -> if (i == pos) { code } else { v } })
}

fun runProgram(program: Program, nthInstruction: Int): Program {
    val inst = program.getNthInstruction(nthInstruction)
    return when (inst) {
        is Instruction.Exit -> program
        is Instruction.Add -> {
            val a = program.readPosition(inst.op1)
            val b = program.readPosition(inst.op2)
            val newProgram = program.writePosition(inst.position, a + b)
            runProgram(newProgram, nthInstruction + 1)
        }
        is Instruction.Mul -> {
            val a = program.readPosition(inst.op1)
            val b = program.readPosition(inst.op2)
            val newProgram = program.writePosition(inst.position, a * b)
            runProgram(newProgram, nthInstruction + 1)
        }
    }
}

fun parseCodes(input: String): List<Int> = input.split(',').map { it.toInt() }

fun reset1202ErrorState(program: Program): Program =
    program.writePosition(1, 12).writePosition(2, 2)
