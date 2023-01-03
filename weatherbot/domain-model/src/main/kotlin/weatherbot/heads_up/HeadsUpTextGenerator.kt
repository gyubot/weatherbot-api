package weatherbot.heads_up

import weatherbot.Weather
import weatherbot.WeatherTextGenerator

class HeadsUpTextGenerator(
    private val headsUpTypeChecker: HeadsUpTypeChecker
) : WeatherTextGenerator {
    override fun generate(weather: Weather): String {
        return headsUpTypeChecker.getType(weather.forecasts)?.text ?: HeadsUpType.TYPE_OTHER.text
    }
}
