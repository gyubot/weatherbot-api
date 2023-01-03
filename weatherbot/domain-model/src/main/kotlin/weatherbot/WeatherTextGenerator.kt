package weatherbot

interface WeatherTextGenerator {
    fun generate(weather: Weather): String
}
