package direction

import direction.Direction
import direction.East
import direction.North
import direction.South

class West: Direction {
    override fun opposite(): Direction {
        return East()
    }

    override fun rotateCounterclockwise(): Direction {
        return South()
    }

    override fun rotateClockwise(): Direction {
        return North()
    }
}