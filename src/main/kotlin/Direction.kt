enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    fun opposite(): Direction {
        return when(this) {
            NORTH -> SOUTH
            EAST -> WEST
            SOUTH -> NORTH
            WEST -> EAST
        }
    }

    fun rotateCounterclockwise(): Direction {
        return when(this) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            WEST -> SOUTH
        }
    }

    fun rotateClockwise(): Direction {
        return when(this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }
}
