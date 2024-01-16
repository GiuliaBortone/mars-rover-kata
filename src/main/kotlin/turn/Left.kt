package turn

import Rover

class Left : Turn {
    override fun turn(rover: Rover) {
        rover.turnLeft()
    }
}
