package weatherbot.temperature

class TemperatureDiff {
    private val referenceTemp = 15
    private val upDown: TempUpDown
    private val currentHotCold: TempHotCold
    private val diffTemp: Int

    constructor(currentTemp: Int, beforeTemp: Int) {
        currentHotCold = if (currentTemp >= referenceTemp) TempHotCold.HOT else TempHotCold.COLD
        upDown = when {
            currentTemp < beforeTemp -> TempUpDown.DOWN
            currentTemp > beforeTemp -> TempUpDown.UP
            else -> TempUpDown.SAME
        }
        diffTemp = currentTemp - beforeTemp
    }

    override fun toString(): String {
        if (upDown == TempUpDown.SAME) {
            return "어제와 비슷하게 ${currentHotCold.text}"
        }
        if (currentHotCold == TempHotCold.HOT && upDown == TempUpDown.DOWN) {
            return "어제보다 ${kotlin.math.abs(diffTemp)}도 덜 ${currentHotCold.text}"
        }
        if (currentHotCold == TempHotCold.HOT && upDown == TempUpDown.UP) {
            return "어제보다 ${kotlin.math.abs(diffTemp)}도 더 ${currentHotCold.text}"
        }
        if (currentHotCold == TempHotCold.COLD && upDown == TempUpDown.DOWN) {
            return "어제보다 ${kotlin.math.abs(diffTemp)}도 더 ${currentHotCold.text}"
        }
        return "어제보다 ${kotlin.math.abs(diffTemp)}도 덜 ${currentHotCold.text}"
    }
}

enum class TempUpDown {
    UP, DOWN, SAME
}

enum class TempHotCold(
    val text: String
) {
    HOT(text = "덥습니다"), COLD(text = "춥습니다")
}
