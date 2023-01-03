package weatherbot.greeting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import weatherbot.WeatherCode
import weatherbot.WeatherHistoricalFixture

class GreetingTypeCompositeCheckerTest {
    @Test
    fun check_함수는_올바른_값을_반환한다() {
        // Arrange
        val currentWeather = WeatherHistoricalFixture.create(
            code = WeatherCode.RAIN, rain1h = 10,
        )
        val sut = GreetingTypeCompositeChecker()

        // Act
        val actual = sut.check(currentWeather)

        // Assert
        assertEquals(GreetingType.TYPE_3, actual)
    }

    @Test
    fun check_함수는_TYPE99를_반환한다() {
        // Arrange
        val currentWeather = WeatherHistoricalFixture.create(
            code = WeatherCode.SUNNY, rain1h = 10,
        )
        val sut = GreetingTypeCompositeChecker()

        // Act
        val actual = sut.check(currentWeather)

        // Assert
        assertEquals(GreetingType.TYPE_99, actual)
    }
}
