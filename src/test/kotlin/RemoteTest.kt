import cardinalPoint.East
import cardinalPoint.North
import cardinalPoint.West
import movement.Backward
import movement.Forward
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import direction.Left
import direction.Right

class RemoteTest {
    @Test
    fun `command rover to turn left`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val remote = Remote(planet, rover)

        assertThat(remote.turnRover(Left())::class).isEqualTo(West()::class)
    }

    @Test
    fun `command rover to turn right`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val remote = Remote(planet, rover)

        assertThat(remote.turnRover(Right())::class).isEqualTo(East()::class)
    }

    @Test
    fun `command rover to move forwards`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val remote = Remote(planet, rover)

        assertThat(remote.moveRover(Forward())).isEqualTo(Coordinates(1, 0))
    }

    @Test
    fun `command rover to move backwards`() {
        val planet = PlanetGrid(3)
        val rover = Rover(Coordinates(1, 1), North())
        val remote = Remote(planet, rover)

        assertThat(remote.moveRover(Backward())).isEqualTo(Coordinates(1, 2))
    }
}