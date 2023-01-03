package weatherbot.temperature

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import weatherbot.Weather
import weatherbot.WeatherHistoricalFixture

class TemperatureTextGeneratorTest {
    @Test
    fun generate_함수는_올바른_문구를_반환한다() {
        // Arrange
        val weather = Weather(
            historicals = listOf(
                WeatherHistoricalFixture.create(
                    hourOffset = 0,
                    temp = 2
                ),
                WeatherHistoricalFixture.create(
                    hourOffset = -6,
                    temp = 30
                ),
                WeatherHistoricalFixture.create(
                    hourOffset = -12,
                    temp = -12
                ),
                WeatherHistoricalFixture.create(
                    hourOffset = -18,
                    temp = -5
                ),
                WeatherHistoricalFixture.create(
                    hourOffset = -24,
                    temp = -9
                ),
            ),
            forecasts = listOf()
        )
        val sut = TemperatureTextGenerator()

        // Act
        val actual = sut.generate(weather)

        // Assert
        assertEquals("어제보다 11도 덜 춥습니다. 최고기온은 30도, 최저기온은 -12도 입니다.", actual)
    }
}
