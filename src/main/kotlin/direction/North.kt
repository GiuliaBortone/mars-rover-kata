package direction

class North: Direction {
    override fun opposite(): Direction {
        return South()
    }

    override fun rotateCounterclockwise(): Direction {
        return West()
    }

    override fun rotateClockwise(): Direction {
        return East()
    }
}