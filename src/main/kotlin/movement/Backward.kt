package movement

import Rover

class Backward: Movement {
    override fun move(rover: Rover) {
        rover.backward()
    }
}