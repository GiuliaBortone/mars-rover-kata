package turn

import Rover

class Right : Turn {
    override fun turn(rover: Rover) {
        rover.turnRight()
    }
}