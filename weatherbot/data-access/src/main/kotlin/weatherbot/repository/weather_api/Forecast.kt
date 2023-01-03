package weatherbot.repository.weather_api

data class Forecast(
    val timestamp: Long,
    val code: Int,
    val minTemp: Double,
    val maxTemp: Double,
    val rain: Int,
) {
    fun toWeatherResponse(hourOffset: Int): WeatherResponse = WeatherResponse(
        hourOffset = hourOffset,
        code = code,
        timestamp = timestamp,
        rain1h = 0,
        temp = 0,
    )
}
