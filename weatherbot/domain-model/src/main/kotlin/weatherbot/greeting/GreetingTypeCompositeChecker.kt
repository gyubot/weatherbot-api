package weatherbot.greeting

import weatherbot.WeatherHistorical

class GreetingTypeCompositeChecker : GreetingTypeChecker {
    private val greetingTypeCheckers: List<GreetingTypeChecker> = listOf(
        Type0(), Type1(), Type2(), Type3(), Type4(), Type5(), Type6(),
    )

    override fun getType(weatherCurrent: WeatherHistorical): GreetingType? {
        greetingTypeCheckers.forEach {
            val type = it.getType(weatherCurrent)
            if (type != null) {
                return type
            }
        }
        return GreetingType.TYPE_99
    }
}
