import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RoverTest {
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

    @ParameterizedTest(name = "to {1} the rover in {0} should move to {2}")
    @MethodSource("getForwardData")
    fun `move forward`(initial: Coordinates, direction: Direction, expectedCoordinates: Coordinates) {
        val rover = Rover(initial, direction)
        rover.forward()
        assertThat(rover.coordinates()).isEqualTo(expectedCoordinates)
    }

    @ParameterizedTest(name = "to {1} the rover in {0} should move to {2}")
    @MethodSource("getBackwardData")
    fun `move backward`(initial: Coordinates, direction: Direction, expectedCoordinates: Coordinates) {
        val rover = Rover(initial, direction)
        rover.backward()
        assertThat(rover.coordinates()).isEqualTo(expectedCoordinates)
    }

    @ParameterizedTest(name = " from {0} to {1}")
    @MethodSource("getTurnLeftData")
    fun `turn left`(initial: Direction, expected: Direction) {
        val rover = Rover(Coordinates(1, 1), initial)
        rover.turnLeft()
        assertThat(rover.coordinates()).isEqualTo(Coordinates(1, 1))
        assertThat(rover.direction()::class).isEqualTo(expected::class)
    }

    @ParameterizedTest(name = " from {0} to {1}")
    @MethodSource("getTurnRightData")
    fun `turn right`(initial: Direction, expected: Direction) {
        val rover = Rover(Coordinates(1, 1), initial)
        rover.turnRight()
        assertThat(rover.coordinates()).isEqualTo(Coordinates(1, 1))
        assertThat(rover.direction()::class).isEqualTo(expected::class)
    }


    companion object {
        @JvmStatic
        fun getForwardData() = listOf(
            Arguments.of(Coordinates(1, 1), North(), Coordinates(1, 0)),
            Arguments.of(Coordinates(1, 1), South(), Coordinates(1, 2)),
            Arguments.of(Coordinates(1, 1), East(), Coordinates(2, 1)),
            Arguments.of(Coordinates(1, 1), West(), Coordinates(0, 1))
        )

        @JvmStatic
        fun getBackwardData() = listOf(
            Arguments.of(Coordinates(1, 1), North(), Coordinates(1, 2)),
            Arguments.of(Coordinates(1, 1), South(), Coordinates(1, 0)),
            Arguments.of(Coordinates(1, 1), East(), Coordinates(0, 1)),
            Arguments.of(Coordinates(1, 1), West(), Coordinates(2, 1))
        )

        @JvmStatic
        fun getTurnLeftData() = listOf(
            Arguments.of(North(), West()),
            Arguments.of(West(), South()),
            Arguments.of(South(), East()),
            Arguments.of(East(), North())
        )

        @JvmStatic
        fun getTurnRightData() = listOf(
            Arguments.of(North(), East()),
            Arguments.of(West(), North()),
            Arguments.of(South(), West()),
            Arguments.of(East(), South())
        )
    }
}