package direction

interface Direction {
    fun opposite(): Direction
    fun rotateCounterclockwise(): Direction
    fun rotateClockwise(): Direction
}