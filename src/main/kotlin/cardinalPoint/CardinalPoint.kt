package cardinalPoint

interface CardinalPoint {
    fun opposite(): CardinalPoint
    fun rotateCounterclockwise(): CardinalPoint
    fun rotateClockwise(): CardinalPoint
}