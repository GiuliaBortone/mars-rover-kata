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

    fun move(movement: Movement, planet: Planet) {
        when (movement) {
            is Forward -> forward(planet)
            is Backward -> backward(planet)
        }
    }

    private fun forward(planet: Planet) {
        coordinates = coordinates.towards(initialCardinalPoint, planet)
    }

    private fun backward(planet: Planet) {
        coordinates = coordinates.towards(initialCardinalPoint.opposite(), planet)
    }

    private fun turnLeft() {
        cardinalPoint = cardinalPoint.rotateCounterclockwise()
    }

    private fun turnRight() {
        cardinalPoint = cardinalPoint.rotateClockwise()
    }
}
