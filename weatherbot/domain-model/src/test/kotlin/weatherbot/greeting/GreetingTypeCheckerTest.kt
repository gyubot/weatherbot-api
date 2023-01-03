package weatherbot.greeting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import weatherbot.WeatherCode

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_0)
    }

    @Test
    fun type0_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type0()

        // Act
        val actual = sut.check(weatherCurrent)

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_1)
    }

    @Test
    fun type1_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type1()

        // Act
        val actual = sut.check(weatherCurrent)

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_2)
    }

    @Test
    fun type2_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type2()

        // Act
        val actual = sut.check(weatherCurrent)

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_3)
    }

    @Test
    fun type3_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type3()

        // Act
        val actual = sut.check(weatherCurrent)

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_4)
    }

    @Test
    fun type4_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type4()

        // Act
        val actual = sut.check(weatherCurrent)

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_5)
    }

    @Test
    fun type5_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical(code = WeatherCode.RAIN)
        val sut = Type5()

        // Act
        val actual = sut.check(weatherCurrent)

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
        val actual = sut.check(weatherCurrent)

        // Assert
        assertEquals(actual, GreetingType.TYPE_6)
    }

    @Test
    fun type6_check_함수는_Null값을_반환한다() {
        // Arrange
        val weatherCurrent = createWeatherHistorical()
        val sut = Type6()

        // Act
        val actual = sut.check(weatherCurrent)

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
