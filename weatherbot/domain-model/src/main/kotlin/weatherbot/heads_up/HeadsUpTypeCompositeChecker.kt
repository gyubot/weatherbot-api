package weatherbot.heads_up

import weatherbot.WeatherForecast

class HeadsUpTypeCompositeChecker : HeadsUpTypeChecker {
    private val checkers = listOf(
        HeadsUpType0Checker(), HeadsUpType1Checker(), HeadsUpType2Checker(), HeadsUpType3Checker(),
    )

    override fun getType(forecasts: List<WeatherForecast>): HeadsUpType? {
        checkers.forEach {
            val type = it.getType(forecasts)
            if (type != null) {
                return type
            }
        }
        return HeadsUpType.TYPE_OTHER
    }
}
