package weatherbot.temperature

import weatherbot.WeatherHistorical

class TemperatureMinMaxTextGenerator {
    fun generate(weathers: List<WeatherHistorical>): String {
        val tempMin = weathers.minOf { it.temp }
        val tempMax = weathers.maxOf { it.temp }
        return "최고기온은 ${tempMax}도, 최저기온은 ${tempMin}도 입니다."
    }
}
