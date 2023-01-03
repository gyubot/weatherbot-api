package weatherbot.greeting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import weatherbot.WeatherCode
import weatherbot.WeatherHistoricalFixture

class GreetingTypeCheckerTest {
    @Test
    fun type0_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            code = WeatherCode.SNOW,
            rain1h = 100,
        )
        val sut = Type0()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_0, actual)
    }

    @Test
    fun type0_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type0()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    @Test
    fun type1_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            code = WeatherCode.SNOW,
        )
        val sut = Type1()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_1, actual)
    }

    @Test
    fun type1_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type1()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    @Test
    fun type2_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            code = WeatherCode.RAIN,
            rain1h = 100,
        )
        val sut = Type2()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_2, actual)
    }

    @Test
    fun type2_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type2()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    @Test
    fun type3_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            code = WeatherCode.RAIN,
        )
        val sut = Type3()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_3, actual)
    }

    @Test
    fun type3_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type3()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    @Test
    fun type4_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            code = WeatherCode.CLOUDY,
        )
        val sut = Type4()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_4, actual)
    }

    @Test
    fun type4_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type4()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    @Test
    fun type5_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            code = WeatherCode.SUNNY,
            temp = 30,
        )
        val sut = Type5()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_5, actual)
    }

    @Test
    fun type5_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(code = WeatherCode.RAIN)
        val sut = Type5()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    @Test
    fun type6_check_함수는_올바른_값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(
            temp = -1
        )
        val sut = Type6()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertEquals(GreetingType.TYPE_6, actual)
    }

    @Test
    fun type6_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type6()

        // Act
        val actual = sut.getType(weatherCurrent)

        // Assert
        assertNull(actual)
    }

    private fun createWeatherHistorical(
        code: WeatherCode = WeatherCode.SUNNY, temp: Int = 0, rain1h: Int = 0,
    ) = WeatherHistoricalFixture.create(
        code = code,
        temp = temp,
        rain1h = rain1h,
    )
}
