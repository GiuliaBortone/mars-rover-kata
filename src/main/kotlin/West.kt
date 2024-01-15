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