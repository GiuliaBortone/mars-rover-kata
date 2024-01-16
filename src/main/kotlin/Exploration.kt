import movement.Movement
import turn.Turn

class Exploration(val planetGrid: PlanetGrid, private val rover: Rover) {
    fun turnRover(turn: Turn) {
        turn.turn(rover)
    }

    fun moveRover(movement: Movement) {
        movement.move(rover)
    }
}
