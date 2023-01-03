package weatherbot

data class WeatherHistorical(
    val hourOffset: Int,
    val timestamp: Long,
    val code: WeatherCode,
    val temp: Int,
    val rain1h: Int,
)
