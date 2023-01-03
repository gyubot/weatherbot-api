package weatherbot

interface WeatherReader {
    fun getWeather(lat: Double, lon: Double): Weather
}
