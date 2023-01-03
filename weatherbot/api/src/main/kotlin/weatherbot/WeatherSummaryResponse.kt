package weatherbot

import com.fasterxml.jackson.annotation.JsonProperty

data class WeatherSummaryResponse(
    val summary: WeatherSummariesResponse
)

data class WeatherSummariesResponse(
    val greeting: String,
    val temperature: String,
    @field:JsonProperty(value = "heads-up")
    val headsUp: String,
)
