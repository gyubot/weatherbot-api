package weatherbot.greeting

import weatherbot.Weather
import weatherbot.WeatherTextGenerator

class GreetingTextGenerator(
    private val greetingTypeChecker: GreetingTypeChecker
) : WeatherTextGenerator {
    override fun generate(weather: Weather): String {
        return greetingTypeChecker.getType(weather.getCurrent())?.text ?: GreetingType.TYPE_99.text
    }
}
