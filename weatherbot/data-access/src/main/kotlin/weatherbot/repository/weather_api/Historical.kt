package weatherbot.repository.weather_api

data class Historical(
    val timestamp: Long,
    val code: Int,
    val temp: Int,
    val rain1h: Int,
) {
    fun toWeatherResponse(hourOffset: Int): WeatherResponse = WeatherResponse(
        hourOffset = hourOffset,
        code = code,
        timestamp = timestamp,
        rain1h = rain1h,
        temp = temp,
    )
}
