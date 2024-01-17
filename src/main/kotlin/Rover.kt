import cardinalPoint.CardinalPoint
import direction.Direction
import direction.Left
import direction.Right
import movement.Backward
import movement.Forward
import movement.Movement

class Rover(initialCoordinates: Coordinates, private val initialCardinalPoint: CardinalPoint) {
    private var coordinates = initialCoordinates
    private var cardinalPoint = initialCardinalPoint

    fun coordinates(): Coordinates {
        return coordinates
    }

    fun direction(): CardinalPoint {
        return cardinalPoint
    }

    fun turn(direction: Direction) {
        when (direction) {
            is Left -> turnLeft()
            is Right -> turnRight()
        }
    }

    fun move(movement: Movement, planetGrid: PlanetGrid) {
        when (movement) {
            is Forward -> forward(planetGrid)
            is Backward -> backward(planetGrid)
        }
    }

    private fun forward(planetGrid: PlanetGrid) {
        coordinates = coordinates.towards(initialCardinalPoint, planetGrid)
    }

    private fun backward(planetGrid: PlanetGrid) {
        coordinates = coordinates.towards(initialCardinalPoint.opposite(), planetGrid)
    }

    private fun turnLeft() {
        cardinalPoint = cardinalPoint.rotateCounterclockwise()
    }

    private fun turnRight() {
        cardinalPoint = cardinalPoint.rotateClockwise()
    }
}
