import direction.Direction
import movement.Movement
import turn.Turn

class Remote(private val planetGrid: PlanetGrid, private val rover: Rover) {
    fun turnRover(turn: Turn): Direction {
        turn.turn(rover)
        return rover.direction()
    }

    fun moveRover(movement: Movement): Coordinates {
        movement.move(planetGrid, rover)
        return rover.coordinates()
    }
}
