package aoc19.day03

import kotlin.math.absoluteValue


fun day03(input: String): String {
    val lines = input.split('\n')
    val intersect = findClosestIntersection(parsePath(lines[0]), parsePath(lines[1]))
    return intersect!!.toString()
}

data class Point(val x: Int, val y: Int)

data class LineSpec(val diff: (Point) -> Point, val length: Int)

class Path private constructor(private val points: List<Point>) {
    companion object {
        fun new(): Path = Path(listOf(Point(0, 0)))
    }

    fun addPoint(point: Point): Path = Path(listOf(point) + points)

    val tailPoint:Point get() = points[0]

    fun intersectWith(path: Path): Set<Point> = points.intersect(path.points)
}

fun manhattanDist(point: Point): Int = point.x.absoluteValue + point.y.absoluteValue

fun addPoints(lineSpec: LineSpec, path: Path): Path = when {
    lineSpec.length < 1 -> path
    else -> addPoints(LineSpec(lineSpec.diff, lineSpec.length - 1),
                      path.addPoint(lineSpec.diff(path.tailPoint)))
}

fun parseLineSpec(s: String): LineSpec {
    val direction = s.take(1)
    val length = s.drop(1)
    val diff = when (direction) {
        "U" -> fun(p: Point) = Point(p.x, p.y + 1)
        "D" -> fun(p: Point) = Point(p.x, p.y - 1)
        "R" -> fun(p: Point) = Point(p.x + 1, p.y)
        "L" -> fun(p: Point) = Point(p.x - 1, p.y)
        else -> throw IllegalStateException("unknown direction")
    }
    return LineSpec(diff, length.toInt())
}

fun buildPath(specs: Iterable<LineSpec>): Path = specs.fold(Path.new()) { acc, spec -> addPoints(spec, acc) }

fun parsePath(input: String): Path = input.split(',').map(::parseLineSpec).let(::buildPath)

fun findClosestIntersection(path1: Path, path2: Path): Int? =
    path1.intersectWith(path2).map(::manhattanDist).filter { it > 0 }.min()
