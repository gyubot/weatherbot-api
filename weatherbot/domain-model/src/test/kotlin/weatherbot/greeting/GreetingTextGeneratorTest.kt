package weatherbot.greeting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import weatherbot.Weather
import weatherbot.WeatherCode

class GreetingTextGeneratorTest {
    @Test
    fun generate_함수는_올바른_값을_반환한다() {
        // Arrange
        val weather =
            Weather(
                historicals =
                listOf(WeatherHistoricalFixture.create(code = WeatherCode.RAIN, rain1h = 999))
            )
        val typeChecker = GreetingTypeCompositeChecker()
        val sut = GreetingTextGenerator(typeChecker)

        // Act
        val actual = sut.generate(weather)

        // Assert
        assertEquals(actual, "폭우가 내리고 있어요.")
    }
}

