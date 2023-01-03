package weatherbot

data class WeatherForecast(
    val hourOffset: Int,
    val timestamp: Long,
    val code: WeatherCode,
)
