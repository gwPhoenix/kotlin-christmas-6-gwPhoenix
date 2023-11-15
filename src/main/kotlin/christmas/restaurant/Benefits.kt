package christmas.restaurant


import christmas.view.InputView
import java.time.DayOfWeek

enum class Benefits(private val koeanText: String, private var benefitBonus: Int) {
    X_MAS_D_DAY("크리스마스 디데이 할인", 0),
    // "1~25일, 1일 : 1000원부터 시작해서 100원씩 증가"

    WEEKDAY_DISCOUNT("평일 할인", 0),
    // "일 ~ 목요일, 디저트 메뉴 1개당 2023원 할인"

    WEEKEND_DISCOUNT("주말 할인", 0),
    // "금 ~ 토, 메인 메뉴 1개당 2023원 할인"

    SPECIAL_DISCOUNT("특별 할인", 0),
    // "별에 해당하는 날, 총 주문금액에서 1000원 할인"

    GIFT_EVENT("증정 이벤트", 0);
    // "총 주문금액 12만원 이상, 샴페인 1개 = 25000원 혜택"

    private fun getBonus(): Int {
        return this.benefitBonus
    }

    private fun setBonus(bonus: Int) {
        this.benefitBonus = bonus
    }

    companion object {
        var benefitInventory = 0
        fun getAllBenefits() {
            if (Bill.Pay.BEFORE_DISCOUNT.getPay() >= 10000) {
                if (getXmasDday() > 0) {
                    println("${X_MAS_D_DAY.koeanText} : -${X_MAS_D_DAY.benefitBonus}원")
                }

                if (getWeekDay() > 0) {
                    println("${WEEKDAY_DISCOUNT.koeanText} : -${WEEKDAY_DISCOUNT.benefitBonus}원")
                }

                if (getWeekend() > 0) {
                    println("${WEEKEND_DISCOUNT.koeanText} : -${WEEKEND_DISCOUNT.benefitBonus}원")
                }

                if(getSpecialStar() > 0){
                    println("${SPECIAL_DISCOUNT.koeanText} : -${SPECIAL_DISCOUNT.benefitBonus}원")
                }

            }

        }

        private fun getXmasDday(): Int {
            benefitInventory = 0
            if (InputView.orderDate in 1..25) {
                benefitInventory = 1000 + ((InputView.orderDate - 1) * 100)
            }
            X_MAS_D_DAY.setBonus(benefitInventory)
            return benefitInventory
        }

        private fun getWeekDay(): Int {
            benefitInventory = 0
            if (Calendar.weekendCheck(InputView.orderDate) != DayOfWeek.SATURDAY
                && Calendar.weekendCheck(InputView.orderDate) != DayOfWeek.FRIDAY
            ) {
                benefitInventory = Menu.Dessert.getDessertInventory() * 2023
            }
            WEEKDAY_DISCOUNT.setBonus(benefitInventory)
            return benefitInventory
        }

        private fun getWeekend(): Int {
            benefitInventory = 0
            if ((Calendar.weekendCheck(InputView.orderDate) == DayOfWeek.SATURDAY
                        || Calendar.weekendCheck(InputView.orderDate) == DayOfWeek.FRIDAY)
            ) {
                benefitInventory = Menu.MainMenu.getMainInventory() * 2023
            }
            WEEKEND_DISCOUNT.setBonus(benefitInventory)
            return benefitInventory
        }

        private fun getSpecialStar() : Int{
            benefitInventory = 0
            Calendar.starDayInventory = Calendar.getAllStarDay()
            if(Calendar.starDayInventory.contains(InputView.orderDate)){
                benefitInventory = 1000
            }
            SPECIAL_DISCOUNT.setBonus(benefitInventory)
            return benefitInventory
        }
    }
}