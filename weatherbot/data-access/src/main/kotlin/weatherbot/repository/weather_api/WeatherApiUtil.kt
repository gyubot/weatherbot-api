package weatherbot.repository.weather_api

import weatherbot.WeatherCode

class WeatherApiUtil {
    companion object {
        fun getWeatherCode(code: Int): WeatherCode {
            return when (code) {
                0 -> WeatherCode.SUNNY
                1 -> WeatherCode.CLOUDY
                2 -> WeatherCode.RAIN
                3 -> WeatherCode.SNOW
                else -> WeatherCode.UNKNOWN
            }
        }
    }
}
