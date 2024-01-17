import cardinalPoint.CardinalPoint
import direction.Left
import direction.Right
import direction.Direction

class Rover(initialCoordinates: Coordinates, private val initialCardinalPoint: CardinalPoint) {
    private var coordinates = initialCoordinates
    private var cardinalPoint = initialCardinalPoint

    fun coordinates(): Coordinates {
        return coordinates
    }

    fun direction(): CardinalPoint {
        return cardinalPoint
    }

    fun forward(planetGrid: PlanetGrid) {
        coordinates = coordinates.towards(initialCardinalPoint, planetGrid)
    }

    fun backward(planetGrid: PlanetGrid) {
        coordinates = coordinates.towards(initialCardinalPoint.opposite(), planetGrid)
    }

    private fun turnLeft() {
        cardinalPoint = cardinalPoint.rotateCounterclockwise()
    }

    private fun turnRight() {
        cardinalPoint = cardinalPoint.rotateClockwise()
    }

    fun turn(direction: Direction) {
        when (direction) {
            is Left -> turnLeft()
            is Right -> turnRight()
        }
    }
}
