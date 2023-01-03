package weatherbot

class WeatherHistoricalFixture {
    companion object {
        fun create(
            code: WeatherCode = WeatherCode.SUNNY, temp: Int = 0, rain1h: Int = 0,
        ) = WeatherHistorical(
            hourOffset = 0,
            timestamp = System.currentTimeMillis(),
            code = code,
            temp = temp,
            rain1h = rain1h,
        )
    }
}
