package weatherbot

class WeatherHistoricalFixture {
    companion object {
        fun create(
            hourOffset: Int = 0, code: WeatherCode = WeatherCode.SUNNY, temp: Int = 0, rain1h: Int = 0,
        ) = WeatherHistorical(
            hourOffset = hourOffset,
            code = code,
            temp = temp,
            rain1h = rain1h,
        )
    }
}
