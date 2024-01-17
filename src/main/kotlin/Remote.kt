import cardinalPoint.CardinalPoint
import movement.Movement
import direction.Direction

class Remote(private val planetGrid: PlanetGrid, private val rover: Rover) {
    fun turnRover(direction: Direction): CardinalPoint {
        rover.turn(direction)
        return rover.direction()
    }

    fun moveRover(movement: Movement): Coordinates {
        rover.move(movement, planetGrid)
        return rover.coordinates()
    }
}
