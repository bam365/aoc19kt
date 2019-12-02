package aoc19


val day01 = intsSolution { numbers ->
    fun fuelUsage(mass: Int) = mass / 3 - 2
    numbers.map(::fuelUsage).sum()
}
