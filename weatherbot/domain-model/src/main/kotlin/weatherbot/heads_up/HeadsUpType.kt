package weatherbot.heads_up

enum class HeadsUpType(
    val text: String,
) {
    TYPE_0(text = "내일 폭설이 내릴 수도 있으니 외출 시 주의하세요."),
    TYPE_1(text = "눈이 내릴 예정이니 외출 시 주의하세요."),
    TYPE_2(text = "폭우가 내릴 예정이에요. 우산을 미리 챙겨두세요."),
    TYPE_3(text = "며칠동안 비 소식이 있어요."),
    TYPE_OTHER(text = "날씨는 대체로 평온할 예정이에요."),
}
