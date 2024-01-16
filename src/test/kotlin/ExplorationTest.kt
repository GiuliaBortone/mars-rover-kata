import direction.East
import direction.North
import direction.West
import movement.Backward
import movement.Forward
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import turn.Left
import turn.Right

class ExplorationTest {
    @Test
    fun `command rover to turn left`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val exploration = Exploration(planet, rover)

        exploration.turnRover(Left())

        assertThat(rover.direction()::class).isEqualTo(West()::class)
    }

    @Test
    fun `command rover to turn right`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val exploration = Exploration(planet, rover)

        exploration.turnRover(Right())

        assertThat(rover.direction()::class).isEqualTo(East()::class)
    }

    @Test
    fun `command rover to move forwards`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val exploration = Exploration(planet, rover)

        exploration.moveRover(Forward())

        assertThat(rover.coordinates()).isEqualTo(Coordinates(1, 0))
    }

    @Test
    fun `command rover to move backwards`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val exploration = Exploration(planet, rover)

        exploration.moveRover(Backward())

        assertThat(rover.coordinates()).isEqualTo(Coordinates(1, 2))
    }
}