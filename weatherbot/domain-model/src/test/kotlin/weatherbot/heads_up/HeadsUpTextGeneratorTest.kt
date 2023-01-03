package weatherbot.heads_up

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import weatherbot.Weather
import weatherbot.WeatherCode
import weatherbot.WeatherForecast
import weatherbot.WeatherForecastFixture

class HeadsUpTextGeneratorTest {
    @ParameterizedTest
    @MethodSource("getForecasts")
    fun generate_함수는_올바른_문구를_반환한다(forecasts: List<WeatherForecast>, expected: String) {
        // Arrange
        val weather = Weather(historicals = emptyList(), forecasts = forecasts)
        val checker = HeadsUpTypeCompositeChecker()
        val sut = HeadsUpTextGenerator(checker)

        // Act
        val actual = sut.generate(weather)

        // Assert
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun getForecasts(): List<Arguments> {
            return listOf(
                Arguments.of(
                    listOf(
                        WeatherForecastFixture.create(hourOffset = 6, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 12, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 18, code = WeatherCode.SNOW),
                        WeatherForecastFixture.create(hourOffset = 24, code = WeatherCode.SNOW),
                        WeatherForecastFixture.create(hourOffset = 30, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 36, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 42, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 48, code = WeatherCode.SUNNY)
                    ),
                    "내일 폭설이 내릴 수도 있으니 외출 시 주의하세요."
                ),
                Arguments.of(
                    listOf(
                        WeatherForecastFixture.create(hourOffset = 6, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 12, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 18, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 24, code = WeatherCode.SNOW),
                        WeatherForecastFixture.create(hourOffset = 30, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 36, code = WeatherCode.SNOW),
                        WeatherForecastFixture.create(hourOffset = 42, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 48, code = WeatherCode.SUNNY)
                    ),
                    "눈이 내릴 예정이니 외출 시 주의하세요."
                ),
                Arguments.of(
                    listOf(
                        WeatherForecastFixture.create(hourOffset = 6, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 12, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 18, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 24, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 30, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 36, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 42, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 48, code = WeatherCode.SUNNY)
                    ),
                    "폭우가 내릴 예정이에요. 우산을 미리 챙겨두세요."
                ),
                Arguments.of(
                    listOf(
                        WeatherForecastFixture.create(hourOffset = 6, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 12, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 18, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 24, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 30, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 36, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 42, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 48, code = WeatherCode.RAIN)
                    ),
                    "며칠동안 비 소식이 있어요."
                ),
                Arguments.of(
                    listOf(
                        WeatherForecastFixture.create(hourOffset = 6, code = WeatherCode.RAIN),
                        WeatherForecastFixture.create(hourOffset = 12, code = WeatherCode.SNOW),
                        WeatherForecastFixture.create(hourOffset = 18, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 24, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 30, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 36, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 42, code = WeatherCode.SUNNY),
                        WeatherForecastFixture.create(hourOffset = 48, code = WeatherCode.SUNNY)
                    ),
                    "날씨는 대체로 평온할 예정이에요."
                ),
            )
        }
    }
}
