class East: Direction {
    override fun opposite(): Direction {
        return West()
    }

    override fun rotateCounterclockwise(): Direction {
        return North()
    }

    override fun rotateClockwise(): Direction {
        return South()
    }
}