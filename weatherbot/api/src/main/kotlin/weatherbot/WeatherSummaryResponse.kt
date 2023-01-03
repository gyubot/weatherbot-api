package weatherbot

data class WeatherSummaryResponse(
    val summary: WeatherSummariesResponse
)

data class WeatherSummariesResponse(
    val greeting: String,
    val temperature: String,
    val headsUp: String,
)
