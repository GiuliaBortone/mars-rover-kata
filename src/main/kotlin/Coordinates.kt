data class Coordinates(val westToEast: Int, val northToSouth: Int) {
    fun towards(direction: Direction): Coordinates {
        return when(direction) {
            Direction.NORTH -> Coordinates(westToEast, northToSouth - 1)
            Direction.SOUTH -> Coordinates(westToEast, northToSouth + 1)
            Direction.WEST -> Coordinates(westToEast - 1, northToSouth)
            Direction.EAST -> Coordinates(westToEast + 1, northToSouth)
        }
    }

    override fun toString(): String {
        return "Coords($westToEast, $northToSouth)"
    }
}
