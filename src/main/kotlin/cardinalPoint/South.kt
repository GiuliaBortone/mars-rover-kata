package cardinalPoint

class South: CardinalPoint {
    override fun opposite(): CardinalPoint {
        return North()
    }

    override fun rotateCounterclockwise(): CardinalPoint {
        return East()
    }

    override fun rotateClockwise(): CardinalPoint {
        return West()
    }
}