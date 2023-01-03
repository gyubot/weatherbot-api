package weatherbot

data class Weather(
    val historicals: List<WeatherHistorical>
) {
    fun getCurrent(): WeatherHistorical =
        historicals.find { it.hourOffset == 0 } ?: throw NoSuchElementException("날씨 정보를 찾을 수 없습니다")

}
