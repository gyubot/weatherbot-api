package weatherbot

class WeatherForecastFixture {
    companion object {
        fun create(
            hourOffset: Int = 0,
            timestamp: Long = System.currentTimeMillis(),
            code: WeatherCode = WeatherCode.SUNNY,
        ): WeatherForecast = WeatherForecast(
            hourOffset = hourOffset,
            code = code,
        )
    }
}
