package christmas.restaurant

import christmas.view.InputView.Companion.orderMenuInventory
import christmas.view.OutputView
import christmas.restaurant.Menu.Appetizer
import christmas.restaurant.Menu.MainMenu
import christmas.restaurant.Menu.Drink
import christmas.restaurant.Menu.Dessert

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
        var decemberBadge = ""
        var beforeDiscountPay = 0
        var benefitsPay = 0

        fun displayDetailPay(separateText: String) {
            when (separateText) {
                Pay.BEFORE_DISCOUNT.toString() -> {
                    println("<${Pay.BEFORE_DISCOUNT.getText()}>")
                    loadPayBeforeDiscount()
                }

                Pay.BENEFIT.toString() -> {
                    println("<${Pay.BENEFIT.getText()}>")
                    loadBenefitsPay()
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

                Benefit.DETAIL.toString() -> {
                    println("<${Benefit.DETAIL.getBenefit()}>")
                    loadBenifits()
                }

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


        fun loadPayBeforeDiscount() {
            Pay.BEFORE_DISCOUNT.setPay(0)
            beforeDiscountPay = 0
            for (clue in orderMenuInventory.keys) {
                beforeDiscountPay +=
                    Appetizer.searchMenuPrice(clue) * orderMenuInventory[clue]!!.toInt()
                beforeDiscountPay +=
                    MainMenu.searchMenuPrice(clue) * orderMenuInventory[clue]!!.toInt()
                beforeDiscountPay +=
                    Drink.searchMenuPrice(clue) * orderMenuInventory[clue]!!.toInt()
                beforeDiscountPay +=
                    Dessert.searchMenuPrice(clue) * orderMenuInventory[clue]!!.toInt()
            }
            Pay.BEFORE_DISCOUNT.setPay(beforeDiscountPay)
            println(OutputView.priceFormat(Pay.BEFORE_DISCOUNT.getPay()))
        }

        fun loadBenefitsPay() {
            Pay.BENEFIT.setPay(0)
            benefitsPay = 0

            benefitsPay += Benefits.X_MAS_D_DAY.getBonus()
            benefitsPay += Benefits.WEEKDAY_DISCOUNT.getBonus()
            benefitsPay += Benefits.WEEKEND_DISCOUNT.getBonus()
            benefitsPay += Benefits.SPECIAL_DISCOUNT.getBonus()
            benefitsPay += Benefits.GIFT_EVENT.getBonus()

            Pay.BENEFIT.setPay(benefitsPay)
            println(OutputView.priceFormat(Pay.BENEFIT.getPay()))
        }

        fun loadGiftMenu(): String {
            if (Pay.BEFORE_DISCOUNT.getPay() >= 120000) {
                Benefits.GIFT_EVENT.setBonus(25000)
                return "샴페인 1개"
            }
            return "없음"
        }

        private fun loadBenifits() {
            Benefits.getAllBenefits()
        }
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


