import direction.Direction

class Rover(initialCoordinates: Coordinates, private val initialDirection: Direction) {
    private var coordinates = initialCoordinates
    private var direction = initialDirection

    fun coordinates(): Coordinates {
        return coordinates
    }

    fun direction(): Direction {
        return direction
    }

    fun forward() {
        coordinates = coordinates.towards(initialDirection)
    }

    fun backward() {
        coordinates = coordinates.towards(initialDirection.opposite())
    }

    fun turnLeft() {
        direction = direction.rotateCounterclockwise()
    }

    fun turnRight() {
        direction = direction.rotateClockwise()
    }
}
