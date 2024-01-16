package movement

import PlanetGrid
import Rover

interface Movement {
    fun move(planetGrid: PlanetGrid, rover: Rover)
}