import cardinalPoint.North
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlanetTest {
    @Test
    fun `calculate coordinates when North`() {
        val planet = Planet(3)
        val target = planet.calculateTargetCoordinate(Coordinates(1, 1), North())

        assertThat(target).isEqualTo(Coordinates(1, 0))
    }


}