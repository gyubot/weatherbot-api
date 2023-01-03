package weatherbot.temperature

import weatherbot.WeatherHistorical

class TemperatureDiffTextGenerator {
    fun generate(current: WeatherHistorical, before: WeatherHistorical): String {
        val diff = TemperatureDiff(currentTemp = current.temp, beforeTemp = before.temp)
        return "${diff}."
    }
}
