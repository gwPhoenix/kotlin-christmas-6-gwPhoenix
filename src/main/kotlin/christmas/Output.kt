package christmas

enum class Output(private val textMessage: String) {
    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_DATA("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU_AND_AMOUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");


    companion object{
        fun getMessage(caseMessage: String) {
            when (caseMessage) {
                REQUEST_DATA.toString() -> {
                    println(START.textMessage)
                    println(REQUEST_DATA.textMessage)
                }

                REQUEST_MENU_AND_AMOUNT.toString() -> println(REQUEST_MENU_AND_AMOUNT)
            }
        }
    }
}