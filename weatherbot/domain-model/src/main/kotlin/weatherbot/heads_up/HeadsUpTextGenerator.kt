package weatherbot.heads_up

import weatherbot.Weather
import weatherbot.WeatherTextGenerator

class HeadsUpTextGenerator : WeatherTextGenerator {
    override fun generate(weather: Weather): String {
        return ""
    }
}
