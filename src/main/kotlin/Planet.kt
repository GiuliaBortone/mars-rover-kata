import cardinalPoint.CardinalPoint

data class Planet(val horizontalMeasure: Int, val verticalMeasure: Int = horizontalMeasure) {
    fun calculateTargetCoordinate(currentCoordinates: Coordinates, cardinalPoint: CardinalPoint): Coordinates {
        return Coordinates(currentCoordinates.westToEast, currentCoordinates.northToSouth - 1)
    }
}
