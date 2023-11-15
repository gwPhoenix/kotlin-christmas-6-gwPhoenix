package christmas.view

import christmas.restaurant.Bill
import christmas.exceptionCheck.CheckSystem
import christmas.restaurant.Menu
import christmas.restaurant.MenuCategory
import christmas.view.InputView.Companion.saveDate

enum class OutputView(private val textMessage: String) {
    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (ex.크리스마스파스타-2, 제로콜라-2)"),
    MENU_INVENTORY(
        "================================메뉴리스트============================"
    ),
    MENU_LINE(
        "===================================================================="
    );

    companion object {
        fun startMessage() {
            println(START.textMessage)
        }

        fun getMessage(caseMessage: String) {
            when (caseMessage) {
                REQUEST_DATE.toString() -> println(REQUEST_DATE.textMessage)
                REQUEST_MENU.toString() -> println(REQUEST_MENU.textMessage)
                MENU_INVENTORY.toString() -> println(MENU_INVENTORY.textMessage)
                MENU_LINE.toString() -> println(MENU_LINE.textMessage)
            }
        }

        fun displayMenu() {
            CheckSystem.keepOn = true // 두번째 while문 실행을 위해 초기화

            getMessage(MENU_INVENTORY.toString())
            getMenuInventory()
            getMessage(MENU_LINE.toString())
        }

        private fun getMenuInventory() {
            println("<${MenuCategory.getCategory(MenuCategory.APPETIZER)}>")
            println(Menu.Appetizer.getAllAppetizerAndPrice())

            println("<${MenuCategory.getCategory(MenuCategory.MAIN_MENU)}>")
            println(Menu.MainMenu.getAllMainAndPrice())

            println("<${MenuCategory.getCategory(MenuCategory.DRINK)}>")
            println(Menu.Drink.getAllDrinkAndPrice())

            println("<${MenuCategory.getCategory(MenuCategory.DESSERT)}>")
            println(Menu.Dessert.getAllDessertAndPrice())
        }

        fun throwIllegalArgumentException(errorMessage: String) {
            try {
                throw IllegalArgumentException()
            } catch (e: IllegalArgumentException) {
                println(errorMessage)
            }
        }

        fun throwNumberFormatException(errorMessage: String) {
            try {
                throw NumberFormatException()
            } catch (e: NumberFormatException) {
                println(errorMessage)
            }
        }

        fun displayBill(visitDate: Int) {
            Bill.setVisitDate(visitDate)
            Bill.loadBenefitPreviewMessage()

            Bill.displayDetailNotPay(Bill.Menu.ORDER.toString())
            Bill.displayDetailPay(Bill.Pay.BEFORE_DISCOUNT.toString())
            Bill.displayDetailNotPay(Bill.Menu.GIFT.toString())

            Bill.displayDetailNotPay(Bill.Benefit.DETAIL.toString())
            Bill.displayDetailPay(Bill.Pay.BENEFIT.toString())
            Bill.displayDetailPay(Bill.Pay.AFTER_DISCOUNT.toString())

            Bill.displayDetailNotPay(Bill.Event.DECEMBER_BADGE.toString())
        }

        fun priceFormat(price: Int): String {
            // 가격을 3자리씩 끊어서 포맷팅
            return String.format("%,d원", price)
        }
    }
}


