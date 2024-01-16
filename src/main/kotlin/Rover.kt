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

    fun forward(planetGrid: PlanetGrid) {
        coordinates = coordinates.towards(initialDirection, planetGrid)
    }

    fun backward(planetGrid: PlanetGrid) {
        coordinates = coordinates.towards(initialDirection.opposite(), planetGrid)
    }

    fun turnLeft() {
        direction = direction.rotateCounterclockwise()
    }

    fun turnRight() {
        direction = direction.rotateClockwise()
    }
}
