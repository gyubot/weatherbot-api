package weatherbot.greeting

import weatherbot.WeatherCode
import weatherbot.WeatherHistorical

interface GreetingTypeChecker {
    fun check(weatherCurrent: WeatherHistorical): GreetingType?
}

class Type0 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 날씨가 눈 이며 강수량이 100mm 이상인 경우
        if (weatherCurrent.rain1h > 99 && weatherCurrent.code == WeatherCode.SNOW) {
            return GreetingType.TYPE_0
        }
        return null
    }
}

class Type1 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 날씨가 눈인 경우
        if (weatherCurrent.code == WeatherCode.SNOW) {
            return GreetingType.TYPE_1
        }
        return null
    }
}

class Type2 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 날씨가 비 이며, 강수량이 100mm 이상인 경우
        if (weatherCurrent.rain1h > 99 && weatherCurrent.code == WeatherCode.RAIN) {
            return GreetingType.TYPE_2
        }
        return null
    }
}

class Type3 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 날씨가 비인 경우
        if (weatherCurrent.code == WeatherCode.RAIN) {
            return GreetingType.TYPE_3
        }
        return null
    }
}

class Type4 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 날씨가 흐림인 경우
        if (weatherCurrent.code == WeatherCode.CLOUDY) {
            return GreetingType.TYPE_4
        }
        return null
    }
}

class Type5 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 날씨가 맑고, 현재 온도가 30도 이상인 경우
        if (weatherCurrent.temp > 29 && weatherCurrent.code == WeatherCode.SUNNY) {
            return GreetingType.TYPE_5
        }
        return null
    }
}

class Type6 : GreetingTypeChecker {
    override fun check(weatherCurrent: WeatherHistorical): GreetingType? {
        // 현재 온도가 0도 이하인 경우
        if (weatherCurrent.temp < 0) {
            return GreetingType.TYPE_6
        }
        return null
    }
}
