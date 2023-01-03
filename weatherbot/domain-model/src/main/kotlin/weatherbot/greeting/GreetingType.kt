package weatherbot.greeting

enum class GreetingType(
    val text: String,
) {
    TYPE_0(text = "폭설이 내리고 있어요."),
    TYPE_1(text = "눈이 포슬포슬 내립니다."),
    TYPE_2(text = "폭우가 내리고 있어요."),
    TYPE_3(text = "비가 오고 있습니다."),
    TYPE_4(text = "날씨가 약간은 칙칙해요."),
    TYPE_5(text = "따사로운 햇살을 맞으세요."),
    TYPE_6(text = "날이 참 춥네요."),
    TYPE_99(text = "날씨가 참 맑습니다."),
}
