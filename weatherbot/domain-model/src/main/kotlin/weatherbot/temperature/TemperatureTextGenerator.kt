package weatherbot.temperature

import weatherbot.Weather
import weatherbot.WeatherTextGenerator

class TemperatureTextGenerator : WeatherTextGenerator {
    private val diffTextGenerator = TemperatureDiffTextGenerator()
    private val minMaxTextGenerator = TemperatureMinMaxTextGenerator()
    override fun generate(weather: Weather): String {
        val current = weather.getCurrent()
        val before24h = weather.getYesterday()
        return "${
            diffTextGenerator.generate(
                current,
                before24h
            )
        } ${minMaxTextGenerator.generate(weather.historicals)}"
    }
}
