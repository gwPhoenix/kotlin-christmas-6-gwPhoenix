package christmas

import christmas.Appetizer as Amenu
import christmas.MainMenu as Mmenu

enum class Output(private val textMessage: String) {
    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 크리스마스파스타-2,제로콜라-2"),
    MENU_INVENTORY(
        "================================메뉴리스트==================================="
    ),
    MENU_LINE(
        "==========================================================================="
    ),
    BILL_INVENTORY(
        " ================================주문내역서===================================");
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

            fun priceFormat(price: Int): String {
                // 가격을 3자리씩 끊어서 포맷팅
                return String.format("%,d", price)
            }

            fun displayMenu() {
                CheckSystem.keepOn = true // 두번째 while문 실행을 위해 초기화

                Output.getMessage(MENU_INVENTORY.toString())
                Output.getMenuInventory1()
                Output.getMenuInventory2()
                Output.getMessage(MENU_LINE.toString())
            }

            fun getMenuInventory1() {
                println("<${MenuCategory.getAppetizer()}>")
                println(
                    "${Amenu.getMushroomSoup()}(${priceFormat(Amenu.getMushroomSoupPrice())})," +
                            " ${Amenu.getTapas()}(${priceFormat(Amenu.getTapasPrice())})," +
                            " ${Amenu.getCaesarSalad()}(${priceFormat(Amenu.getCaesarSaladPrice())})"
                )

                println("<${MenuCategory.getMain()}>")
                println(
                    "${Mmenu.getBBQLip()}(${priceFormat(Mmenu.getTboneSteakPrice())})," +
                            " ${Mmenu.getBBQLip()}(${priceFormat(Mmenu.getBBQLipPrice())})," +
                            " ${Mmenu.getSeafoodPasta()}(${priceFormat(Mmenu.getSeafoodPastaPrice())})," +
                            " ${Mmenu.getXmasPasta()}(${priceFormat(Mmenu.getXmasPastaPrice())})"
                )
            }

            fun getMenuInventory2() {
                println("<${MenuCategory.getDessert()}>")
                println(
                    "${Dessert.getChocolateCake()}(${priceFormat(Dessert.getChocolateCakePrice())})," +
                            " ${Dessert.getIceCream()}(${priceFormat(Dessert.getIceCreamPrice())})"
                )
                println("<${MenuCategory.getDrink()}>")
                println(
                    "${Drink.getZeroCola()}(${priceFormat(Drink.getZeroColaPrice())})," +
                            " ${Drink.getRedWine()}(${priceFormat(Drink.getRedWinePrice())})," +
                            " ${Drink.getChampagne()}(${priceFormat(Drink.getChampagnePrice())})"
                )
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

            fun displayBill() {
                println(BILL_INVENTORY.textMessage)
                Bill.displayDetail(Bill.Event.MESSAGE.toString())
                Bill.displayDetail(Bill.Menu.ORDER.toString())
                Bill.displayDetail(Bill.Pay.BEFORE_DISCOUNT.toString())
                Bill.displayDetail(Bill.Menu.GIFT.toString())
                Bill.displayDetail(Bill.Benefit.DETAIL.toString())
                Bill.displayDetail(Bill.Pay.BENEFIT.toString())
                Bill.displayDetail(Bill.Pay.AFTER_DISCOUNT.toString())
                Bill.displayDetail(Bill.Event.DECEMBER_BADGE.toString())
            }
        }
}


