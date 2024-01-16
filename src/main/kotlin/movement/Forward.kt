package movement

import PlanetGrid
import Rover

class Forward: Movement {
    override fun move(planetGrid: PlanetGrid, rover: Rover) {
        rover.forward(planetGrid)
    }
}