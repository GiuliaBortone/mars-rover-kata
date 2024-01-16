import direction.*

data class Coordinates(val westToEast: Int, val northToSouth: Int) {
    fun towards(direction: Direction): Coordinates {
        return when (direction) {
            is North -> Coordinates(westToEast, northToSouth - 1)
            is South -> Coordinates(westToEast, northToSouth + 1)
            is West -> Coordinates(westToEast - 1, northToSouth)
            is East -> Coordinates(westToEast + 1, northToSouth)
            else -> {
                Coordinates(westToEast, northToSouth)
            }
        }
    }

    override fun toString(): String {
        return "Coords($westToEast, $northToSouth)"
    }
}
