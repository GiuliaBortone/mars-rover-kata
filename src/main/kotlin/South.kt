class South: Direction {
    override fun opposite(): Direction {
        return North()
    }

    override fun rotateCounterclockwise(): Direction {
        return East()
    }

    override fun rotateClockwise(): Direction {
        return West()
    }
}