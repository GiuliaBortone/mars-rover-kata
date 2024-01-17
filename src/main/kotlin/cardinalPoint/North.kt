package cardinalPoint

class North: CardinalPoint {
    override fun opposite(): CardinalPoint {
        return South()
    }

    override fun rotateCounterclockwise(): CardinalPoint {
        return West()
    }

    override fun rotateClockwise(): CardinalPoint {
        return East()
    }
}