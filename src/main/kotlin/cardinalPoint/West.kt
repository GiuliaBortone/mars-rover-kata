package cardinalPoint

class West: CardinalPoint {
    override fun opposite(): CardinalPoint {
        return East()
    }

    override fun rotateCounterclockwise(): CardinalPoint {
        return South()
    }

    override fun rotateClockwise(): CardinalPoint {
        return North()
    }
}