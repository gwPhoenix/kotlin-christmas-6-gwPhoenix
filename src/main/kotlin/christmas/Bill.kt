package christmas

enum class Bill(private val koreanText: String) {
    EVENT_MESSAGE("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("주문 메뉴"),
    GIFT_MENU("증정 메뉴"),
    BENEFIT_DETAIL("혜택 내역"),
    DECEMBER_EVENT_BADGE("12월 이벤트 배지"),

    PAY_BEFORE_DISCOUNT("할인 전 총주문 금액"),
    PAY_BENEFIT("총혜택 금액"),
    PAY_AFTER_DISCOUNT("할인 후 예상 결제 금액");
    companion object {
        var orderMenuBag = mutableMapOf<String, Int>()
        var giftMenuBag = ""
        var benefitBag = mutableMapOf<String, Int>()

        var discoutBeforePay = 0
        var totalBenefit = 0
        var discountAtferPay = 0

        var decemberBadge = ""
        fun displayDetail(separateText: String) {
            println("")
            when (separateText) {
                ORDER_MENU.toString() -> println("<${ORDER_MENU.koreanText}>")
                PAY_BEFORE_DISCOUNT.toString() -> println("<${PAY_BEFORE_DISCOUNT.koreanText}>")
                GIFT_MENU.toString() -> println("<${GIFT_MENU.koreanText}>")
                BENEFIT_DETAIL.toString() -> println("<${BENEFIT_DETAIL.koreanText}>")
                PAY_BENEFIT.toString() -> println("<${PAY_BENEFIT.koreanText}>")
                PAY_AFTER_DISCOUNT.toString() -> println("<${PAY_AFTER_DISCOUNT.koreanText}>")
                DECEMBER_EVENT_BADGE.toString() -> println("<${DECEMBER_EVENT_BADGE.koreanText}>")
            }
        }

        fun loadBage(discountPay: Int) {
            when (discountPay) {
                discountPay > 20000 -> println("산타")
                discountPay in 10000..19999 -> println("트리")
                discountPay in 5000..9999 -> println("별")
                else -> println("없음")
                TODO("수정중")
            }

        }
    }
}