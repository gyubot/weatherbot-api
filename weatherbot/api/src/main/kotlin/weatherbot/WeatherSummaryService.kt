package weatherbot

class WeatherSummaryService(
    private val greetingTextGenerator: WeatherTextGenerator,
    private val temperatureTextGenerator: WeatherTextGenerator,
    private val headsUpTextGenerator: WeatherTextGenerator,
    private val weatherReader: WeatherReader,
) {
    fun getSummaryResponse(lat: Double, lon: Double): WeatherSummaryResponse {
        val weather = weatherReader.getWeather(lat = lat, lon = lon)
        return WeatherSummaryResponse(
            summary = WeatherSummariesResponse(
                greeting = greetingTextGenerator.generate(weather),
                temperature = temperatureTextGenerator.generate(weather),
                headsUp = headsUpTextGenerator.generate(weather)
            )
        )
    }
}
