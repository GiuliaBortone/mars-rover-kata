package movement

import Rover

class Forward: Movement {
    override fun move(rover: Rover) {
        rover.forward()
    }
}