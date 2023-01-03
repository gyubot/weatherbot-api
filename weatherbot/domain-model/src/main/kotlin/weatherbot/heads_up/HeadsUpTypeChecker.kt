package weatherbot.heads_up

import weatherbot.WeatherCode
import weatherbot.WeatherForecast

interface HeadsUpTypeChecker {
    fun getType(forecasts: List<WeatherForecast>): HeadsUpType?
}

class HeadsUpType0Checker : HeadsUpTypeChecker {
    override fun getType(forecasts: List<WeatherForecast>): HeadsUpType? {
        // 앞으로 24시간 내에 눈이 내릴 것으로 예측되는 경우가 12시간 이상
        val snowCount = forecasts
            .take(4).filter { it.code == WeatherCode.SNOW }.size
        return if (snowCount >= 2) HeadsUpType.TYPE_0 else null
    }
}

class HeadsUpType1Checker : HeadsUpTypeChecker {
    override fun getType(forecasts: List<WeatherForecast>): HeadsUpType? {
        // 앞으로 48시간 내에 눈이 내릴 것으로 예측되는 경우가 12시간 이상
        val snowCount = forecasts
            .filter { it.code == WeatherCode.SNOW }.size
        return if (snowCount >= 2) HeadsUpType.TYPE_1 else null
    }
}

class HeadsUpType2Checker : HeadsUpTypeChecker {
    override fun getType(forecasts: List<WeatherForecast>): HeadsUpType? {
        // 앞으로 24시간 내에 비가 내릴 것으로 예측되는 경우가 12시간 이상
        val rainCount = forecasts
            .take(4).filter { it.code == WeatherCode.RAIN }.size
        return if (rainCount >= 2) HeadsUpType.TYPE_2 else null
    }
}

class HeadsUpType3Checker : HeadsUpTypeChecker {
    override fun getType(forecasts: List<WeatherForecast>): HeadsUpType? {
        // 앞으로 48시간 이내에 비가 내릴 것으로 예측되는 경우가 12시간 이상
        val rainCount = forecasts
            .filter { it.code == WeatherCode.RAIN }.size
        return if (rainCount >= 2) HeadsUpType.TYPE_3 else null
    }
}
