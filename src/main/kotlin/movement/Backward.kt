package movement

import PlanetGrid
import Rover

class Backward: Movement {
    override fun move(planetGrid: PlanetGrid, rover: Rover) {
        rover.backward(planetGrid)
    }
}