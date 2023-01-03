package weatherbot.temperature

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import weatherbot.greeting.WeatherHistoricalFixture

class TemperatureMinMaxTextGeneratorTest {

    @Test
    fun generate_함수는_올바른_값을_반환한다() {
        // Arrange
        val weathers = listOf(
            WeatherHistoricalFixture.create(
                temp = 2
            ),
            WeatherHistoricalFixture.create(
                temp = 30
            ),
            WeatherHistoricalFixture.create(
                temp = -5
            ),
        )
        val sut = TemperatureMinMaxTextGenerator()

        // Act
        val actual = sut.generate(weathers)

        // Assert
        assertEquals(actual, "최고기온은 30도, 최저기온은 -5도 입니다.")
    }
}
