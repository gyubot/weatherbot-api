package weatherbot

interface WeatherReader {
    fun getWeather(lat: Float, lon: Float): Weather
}
