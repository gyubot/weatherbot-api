package weatherbot

data class Weather(
    val historicals: List<WeatherHistorical>,
    val forecasts: List<WeatherForecast>,
) {
    fun getCurrent(): WeatherHistorical =
        historicals.find { it.hourOffset == 0 } ?: throw NoSuchElementException("날씨 정보를 찾을 수 없습니다")

    fun getYesterday(): WeatherHistorical =
        historicals.find { it.hourOffset == -24 } ?: throw NoSuchElementException("날씨 정보를 찾을 수 없습니다")
}
