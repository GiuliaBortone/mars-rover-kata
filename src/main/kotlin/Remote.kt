import cardinalPoint.CardinalPoint
import movement.Movement
import direction.Direction

class Remote(private val planet: Planet, private val rover: Rover) {
    fun turnRover(direction: Direction): CardinalPoint {
        rover.turn(direction)
        return rover.direction()
    }

    fun moveRover(movement: Movement): Coordinates {
        rover.move(movement, planet)
        return rover.coordinates()
    }
}
