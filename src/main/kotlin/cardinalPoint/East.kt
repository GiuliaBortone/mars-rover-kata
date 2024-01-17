package cardinalPoint

class East: CardinalPoint {
    override fun opposite(): CardinalPoint {
        return West()
    }

    override fun rotateCounterclockwise(): CardinalPoint {
        return North()
    }

    override fun rotateClockwise(): CardinalPoint {
        return South()
    }
}