package weatherbot

class WeatherForecastFixture {
    companion object {
        fun create(
            hourOffset: Int = 0,
            code: WeatherCode = WeatherCode.SUNNY,
        ): WeatherForecast = WeatherForecast(
            hourOffset = hourOffset,
            code = code,
        )
    }
}
