package christmas

import christmas.Input.Companion.orderMenuInventory

class Bill() {
    enum class Pay(private val koreanText: String, private var finalPrice: Int) {
        BEFORE_DISCOUNT("할인 전 총주문 금액", 0),
        BENEFIT("총혜택 금액", 0),
        AFTER_DISCOUNT("할인 후 예상 결제 금액", 0);

        fun getText(): String {
            return this.koreanText
        }

        fun getPay(): Int {
            return this.finalPrice
        }

        fun setPay(price: Int) {
            this.finalPrice = price
        }
    }

    enum class Menu(private val koreanText: String) {
        ORDER("주문 메뉴"),
        GIFT("증정 메뉴");

        fun getMenu(): String {
            return this.koreanText
        }

    }

    enum class Event(private val koreanText: String) {
        MESSAGE("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
        DECEMBER_BADGE("12월 이벤트 배지");

        fun getEvent(): String {
            return this.koreanText
        }
    }


    enum class Benefit(private val koreanText: String) {
        DETAIL("혜택 내역");

        fun getBenefit(): String {
            return this.koreanText
        }
    }

    companion object {
        var giftMenuBag = ""
        var benefitBag = mutableMapOf<String, Int>()
        var decemberBadge = ""
        var beforeDiscountPay = 0

        fun displayDetailPay(separateText: String) {
            when (separateText) {
                Pay.BEFORE_DISCOUNT.toString() -> {
                    println("<${Pay.BEFORE_DISCOUNT.getText()}>")
                    println(Output.priceFormat(loadPayBeforeDiscount()))
                }

                Pay.BENEFIT.toString() -> {
                    println("<${Pay.BENEFIT.getText()}>")
                }

                Pay.AFTER_DISCOUNT.toString() -> {
                    println("<${Pay.BEFORE_DISCOUNT.getText()}>")
                }
            }
            println("")
        }

        fun displayDetailNotPay(separateText: String) {
            when (separateText) {
                Menu.ORDER.toString() -> {
                    println("<${Menu.ORDER.getMenu()}>")
                    loadOderMenuInventory()
                }

                Menu.GIFT.toString() -> {
                    println("<${Menu.GIFT.getMenu()}>")
                    println(loadGiftMenu())
                }

                Benefit.DETAIL.toString() -> println("<${Benefit.DETAIL.getBenefit()}>")
                Event.DECEMBER_BADGE.toString() -> {
                    println("<${Event.DECEMBER_BADGE.getEvent()}>")
                }
            }
            println("")
        }

        fun loadOderMenuInventory() {
            for (clue in orderMenuInventory.keys) {
                println("${clue} ${orderMenuInventory[clue]}개")
            }
        }


        fun loadPayBeforeDiscount(): Int {
            Pay.BEFORE_DISCOUNT.setPay(0)
            beforeDiscountPay = 0
            for (clue in orderMenuInventory.keys) {
                beforeDiscountPay +=
                    christmas.Menu.Appetizer.searchMenu(clue) * orderMenuInventory[clue]!!.toInt()
                beforeDiscountPay +=
                    christmas.Menu.MainMenu.searchMenu(clue) * orderMenuInventory[clue]!!.toInt()
                beforeDiscountPay +=
                    christmas.Menu.Drink.searchMenu(clue) * orderMenuInventory[clue]!!.toInt()
                beforeDiscountPay +=
                    christmas.Menu.Dessert.searchMenu(clue) * orderMenuInventory[clue]!!.toInt()
            }
            Pay.BEFORE_DISCOUNT.setPay(beforeDiscountPay)
            return Pay.BEFORE_DISCOUNT.getPay()
        }

        fun loadGiftMenu(): String {
            if (Pay.BEFORE_DISCOUNT.getPay() > 120000) {
                return "샴페인 1개"
            }
            return "없음"
        }
    }


    /* fun loadPay(separateText: String) {
         when (separateText) {
             PAY_BEFORE_DISCOUNT.toString() -> println("할인 전 총주문 금액 출력")
             PAY_BENEFIT.toString() -> println("총혜택 금액 출력")
             PAY_AFTER_DISCOUNT.toString() -> println("할인 후 예상 결제 금액 출력")
         }

     }*/

    /*fun loadBage(discountPay: Int) {
        when (discountPay) {
            discountPay > 20000 -> println("산타")
            discountPay in 10000..19999 -> println("트리")
            discountPay in 5000..9999 -> println("별")
            else -> println("없음")
            TODO("수정중")
        }

    }*/

}
