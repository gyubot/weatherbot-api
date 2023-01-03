package weatherbot.repository.weather_api

import weatherbot.WeatherForecast
import weatherbot.WeatherHistorical

data class WeatherResponse(
    val hourOffset: Int,
    val timestamp: Long,
    val code: Int,
    val temp: Int,
    val rain1h: Int,
) {
    fun toForecastEntity(): WeatherForecast = WeatherForecast(
        hourOffset = hourOffset,
        code = WeatherApiUtil.getWeatherCode(code),
    )

    fun toHistoricalEntity(): WeatherHistorical = WeatherHistorical(
        hourOffset = hourOffset,
        code = WeatherApiUtil.getWeatherCode(code),
        temp = temp,
        rain1h = rain1h,
    )
}
