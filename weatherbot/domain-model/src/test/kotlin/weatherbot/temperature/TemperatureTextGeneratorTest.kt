package weatherbot.temperature

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import weatherbot.WeatherHistorical
import weatherbot.WeatherHistoricalFixture

class TemperatureTextGeneratorTest {
    @ParameterizedTest
    @MethodSource("getWeatherDatas")
    fun generate_함수는_24시간전_날씨와_현재_날씨를_바탕으로_올바른_문구를_반환한다(
        current: WeatherHistorical,
        before24h: WeatherHistorical,
        text: String
    ) {
        // Arrange
        val sut = TemperatureDiffTextGenerator()

        // Act
        val actual = sut.generate(current = current, before = before24h)

        // Assert
        assertEquals(text, actual)
    }


    companion object {
        @JvmStatic
        fun getWeatherDatas(): List<Arguments> {
            return listOf(
                Arguments.of(
                    WeatherHistoricalFixture.create(temp = 15), WeatherHistoricalFixture.create(temp = 16),
                    "어제보다 1도 덜 덥습니다."
                ),
                Arguments.of(
                    WeatherHistoricalFixture.create(temp = 14), WeatherHistoricalFixture.create(temp = 15),
                    "어제보다 1도 더 춥습니다."
                ),
                Arguments.of(
                    WeatherHistoricalFixture.create(temp = 15), WeatherHistoricalFixture.create(temp = 14),
                    "어제보다 1도 더 덥습니다."
                ),
                Arguments.of(
                    WeatherHistoricalFixture.create(temp = 14), WeatherHistoricalFixture.create(temp = 13),
                    "어제보다 1도 덜 춥습니다."
                ),
                Arguments.of(
                    WeatherHistoricalFixture.create(temp = 15), WeatherHistoricalFixture.create(temp = 15),
                    "어제와 비슷하게 덥습니다."
                ),
                Arguments.of(
                    WeatherHistoricalFixture.create(temp = 14), WeatherHistoricalFixture.create(temp = 14),
                    "어제와 비슷하게 춥습니다."
                ),
            )
        }
    }
}
