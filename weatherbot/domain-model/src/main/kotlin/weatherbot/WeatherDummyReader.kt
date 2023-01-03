package weatherbot

class WeatherDummyReader : WeatherReader {
    override fun getWeather(lat: Float, lon: Float): Weather {
        return Weather(
            historicals = listOf(
                WeatherHistorical(
                    hourOffset = 0,
                    code = WeatherCode.RAIN,
                    temp = 5,
                    rain1h = 10,
                ),
                WeatherHistorical(
                    hourOffset = -6,
                    code = WeatherCode.RAIN,
                    temp = 1,
                    rain1h = 100,
                ),
                WeatherHistorical(
                    hourOffset = -12,
                    code = WeatherCode.RAIN,
                    temp = 1,
                    rain1h = 100,
                ),
                WeatherHistorical(
                    hourOffset = -18,
                    code = WeatherCode.RAIN,
                    temp = 1,
                    rain1h = 100,
                ),
                WeatherHistorical(
                    hourOffset = -24,
                    code = WeatherCode.RAIN,
                    temp = 1,
                    rain1h = 100,
                ),
            ),
            forecasts = listOf(
                WeatherForecast(
                    hourOffset = 6,
                    code = WeatherCode.SUNNY,
                ),
                WeatherForecast(
                    hourOffset = 12,
                    code = WeatherCode.RAIN,
                ),
                WeatherForecast(
                    hourOffset = 18,
                    code = WeatherCode.RAIN,
                ),
                WeatherForecast(
                    hourOffset = 24,
                    code = WeatherCode.SUNNY,
                ),
                WeatherForecast(
                    hourOffset = 30,
                    code = WeatherCode.SUNNY,
                ),
                WeatherForecast(
                    hourOffset = 36,
                    code = WeatherCode.SUNNY,
                ),
                WeatherForecast(
                    hourOffset = 42,
                    code = WeatherCode.SUNNY,
                ),
                WeatherForecast(
                    hourOffset = 48,
                    code = WeatherCode.SUNNY,
                ),
            ),
        )
    }
}
