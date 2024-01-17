import cardinalPoint.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import direction.Left
import direction.Right
import direction.Direction
import movement.Backward
import movement.Forward
import movement.Movement

class RoverTest {
    private val planet = Planet(3, 4)

    @Test
    fun `coordinates gives the actual position`() {
        val rover = Rover(Coordinates(1, 1), North())
        assertThat(rover.coordinates()).isEqualTo(Coordinates(1, 1))
    }

    @Test
    fun `coordinates gives the actual direction`() {
        val rover = Rover(Coordinates(1, 1), North())
        assertThat(rover.direction()::class).isEqualTo(North::class)
    }

    @ParameterizedTest(name = "to {1} the rover in {0} should move to {2} moving {3}")
    @MethodSource("getMovementData")
    fun move(initial: Coordinates, cardinalPoint: CardinalPoint, expectedCoordinates: Coordinates, movement: Movement) {
        val rover = Rover(initial, cardinalPoint)
        rover.move(movement, planet)
        assertThat(rover.coordinates()).isEqualTo(expectedCoordinates)
    }

    @ParameterizedTest(name = "to {1} the rover in {0} should move to {2}")
    @MethodSource("getMovementDataForEdgeCases")
    fun `edge cases - move`(initial: Coordinates, cardinalPoint: CardinalPoint, expectedCoordinates: Coordinates, movement: Movement) {
        val rover = Rover(initial, cardinalPoint)
        rover.move(movement, planet)
        assertThat(rover.coordinates()).isEqualTo(expectedCoordinates)
    }

    @ParameterizedTest(name = "{2} from {0} to {1}")
    @MethodSource("getTurnData")
    fun turn(initial: CardinalPoint, expected: CardinalPoint, direction: Direction) {
        val rover = Rover(Coordinates(1, 1), initial)
        rover.turn(direction)
        assertThat(rover.coordinates()).isEqualTo(Coordinates(1, 1))
        assertThat(rover.direction()::class).isEqualTo(expected::class)
    }

    companion object {
        @JvmStatic
        fun getTurnData() = listOf(
            Arguments.of(North(), West(), Left()),
            Arguments.of(West(), South(), Left()),
            Arguments.of(South(), East(), Left()),
            Arguments.of(East(), North(), Left()),
            Arguments.of(North(), East(), Right()),
            Arguments.of(West(), North(), Right()),
            Arguments.of(South(), West(), Right()),
            Arguments.of(East(), South(), Right())
        )

        @JvmStatic
        fun getMovementData() = listOf(
            Arguments.of(Coordinates(1, 1), North(), Coordinates(1, 0), Forward()),
            Arguments.of(Coordinates(1, 1), South(), Coordinates(1, 2), Forward()),
            Arguments.of(Coordinates(1, 1), East(), Coordinates(2, 1), Forward()),
            Arguments.of(Coordinates(1, 1), West(), Coordinates(0, 1), Forward()),
            Arguments.of(Coordinates(1, 1), North(), Coordinates(1, 2), Backward()),
            Arguments.of(Coordinates(1, 1), South(), Coordinates(1, 0), Backward()),
            Arguments.of(Coordinates(1, 1), East(), Coordinates(0, 1), Backward()),
            Arguments.of(Coordinates(1, 1), West(), Coordinates(2, 1), Backward())
        )

        @JvmStatic
        fun getMovementDataForEdgeCases() = listOf(
            Arguments.of(Coordinates(1, 0), North(), Coordinates(1, 3), Forward()),
            Arguments.of(Coordinates(1, 3), South(), Coordinates(1, 0), Forward()),
            Arguments.of(Coordinates(0, 1), West(), Coordinates(2, 1), Forward()),
            Arguments.of(Coordinates(2, 1), East(), Coordinates(0, 1), Forward()),
            Arguments.of(Coordinates(1, 0), South(), Coordinates(1, 3), Backward()),
            Arguments.of(Coordinates(1, 3), North(), Coordinates(1, 0), Backward()),
            Arguments.of(Coordinates(0, 1), East(), Coordinates(2, 1), Backward()),
            Arguments.of(Coordinates(2, 1), West(), Coordinates(0, 1), Backward())
        )
    }
}