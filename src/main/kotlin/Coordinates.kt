import cardinalPoint.*

data class Coordinates(val westToEast: Int, val northToSouth: Int) {
    fun towards(cardinalPoint: CardinalPoint, planet: Planet): Coordinates {
        return when (cardinalPoint) {
            is North -> {
                if (northToSouth == 0) {
                    Coordinates(westToEast, planet.verticalMeasure - 1)
                } else {
                    Coordinates(westToEast, northToSouth - 1)
                }
            }

            is South -> {
                if (northToSouth == planet.verticalMeasure - 1) {
                    Coordinates(westToEast, 0)
                } else {
                    Coordinates(westToEast, northToSouth + 1)
                }
            }

            is West -> {
                if (westToEast == 0) {
                    Coordinates(planet.horizontalMeasure - 1, northToSouth)
                } else {
                    Coordinates(westToEast - 1, northToSouth)
                }
            }

            is East -> {
                if (westToEast == planet.horizontalMeasure - 1) {
                    Coordinates(0, northToSouth)
                } else {
                    Coordinates(westToEast + 1, northToSouth)
                }
            }

            else -> {
                Coordinates(westToEast, northToSouth)
            }
        }
    }

    override fun toString(): String {
        return "Coords($westToEast, $northToSouth)"
    }
}
