package christmas

import camp.nextstep.edu.missionutils.test.NsTest
import christmas.restaurant.Benefits
import christmas.restaurant.Bill
import christmas.restaurant.Calendar
import christmas.restaurant.EventBadge
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.DayOfWeek

class BusinessLogicTest : NsTest() {
    @ValueSource(strings=[" ", "","　","\n"])
    @ParameterizedTest
    fun `공백 체크`(inputText: String) {
        Assertions.assertTrue(inputText.isBlank())
    }

    @ValueSource(strings = ["1일","a"])
    @ParameterizedTest
    fun `날짜 예외 체크`(strings: String) {
            assertNull(strings.toIntOrNull())
    }

    @CsvSource("1:1",delimiter = ':')
    @ParameterizedTest
    fun `날짜 체크`(dates: String, result: Int) {
        Assertions.assertEquals(dates.toInt(), result)
    }

    @CsvSource("0:false", "15:true", "32:false", delimiter = ':')
    @ParameterizedTest
    fun `날짜 범위 체크`(dates: Int, bool: Boolean) {
        Assertions.assertEquals(dates in 1..31, bool)
    }


    @CsvSource("파스타-1:true", "파스타 - 1:false", delimiter = ':')
    @ParameterizedTest
    fun `메뉴형식 체크`(inputText: String) {
        var menuCheckRegularExpression = Regex("""^[가-힣]+-\d+(,\s*[가-힣]+-\d+)*$""")

        inputText.matches(menuCheckRegularExpression)
    }

    @Test
    fun `금액 계산 체크`() {
        Bill.Pay.BEFORE_DISCOUNT.setPay(0)
        Bill.beforeDiscountPay = 0
        Bill.beforeDiscountPay = 55000 + 54000 + 5500
        Bill.Pay.BEFORE_DISCOUNT.setPay(Bill.beforeDiscountPay)
        Assertions.assertEquals(Bill.Pay.BEFORE_DISCOUNT.getPay(), 114500)
    }


    @CsvSource(
        "1:1000", "5:1400", "10:1900", "15:2400", "20:2900", "25:3400",
        delimiter = ':'
    )
    @ParameterizedTest
    fun `크리스마스 이벤트날 확인`(date: Int, price: Int) {
        Benefits.X_MAS_D_DAY.setBonus(0)
        Benefits.benefitInventory = 0
        if (date in 1..25) {
            Benefits.benefitInventory = 1000 + ((date - 1) * 100)
        }
        Benefits.X_MAS_D_DAY.setBonus(Benefits.benefitInventory)
        Assertions.assertEquals(Benefits.X_MAS_D_DAY.getBonus(), price)
    }

    @CsvSource(
        "3:1000", "10:1000", "17:1000", "24:1000", "25:1000", "31:1000",
        "2:0", "9:0", "16:0", "23:0", "30:0",
        delimiter = ':'
    )
    @ParameterizedTest
    fun `별 이벤트날 확인`(date: Int, price: Int) {
        Benefits.SPECIAL_DISCOUNT.setBonus(0)
        Benefits.benefitInventory = 0
        Calendar.starDayInventory = Calendar.getAllStarDay()
        if (Calendar.starDayInventory.contains(date)) {
            Benefits.benefitInventory = 1000
        }
        Benefits.SPECIAL_DISCOUNT.setBonus(Benefits.benefitInventory)
        Assertions.assertEquals(Benefits.SPECIAL_DISCOUNT.getBonus(), price)
    }

    @CsvSource(
        "1:0", "9:0", "15:0", "23:0", "29:0",
        "4:2023", "12:2023", "20:2023", "28:2023",
        delimiter = ':'
    )
    @ParameterizedTest
    fun `평일 확인`(date: Int, price: Int) {
        Benefits.WEEKDAY_DISCOUNT.setBonus(0)
        Benefits.benefitInventory = 0
        if (Calendar.weekendCheck(date) != DayOfWeek.SATURDAY
            && Calendar.weekendCheck(date) != DayOfWeek.FRIDAY
        ) {
            Benefits.benefitInventory = 2023
        }
        Benefits.WEEKDAY_DISCOUNT.setBonus(Benefits.benefitInventory)
        Assertions.assertEquals(Benefits.WEEKDAY_DISCOUNT.getBonus(), price)
    }

    @CsvSource(
        "1:2023", "9:2023", "15:2023", "23:2023", "29:2023",
        "4:0", "12:0", "20:0", "28:0",
        delimiter = ':'
    )
    @ParameterizedTest
    fun `주말 확인`(date: Int, price: Int) {
        Benefits.WEEKEND_DISCOUNT.setBonus(0)
        Benefits.benefitInventory = 0
        if ((Calendar.weekendCheck(date) == DayOfWeek.SATURDAY
                    || Calendar.weekendCheck(date) == DayOfWeek.FRIDAY)
        ) {
            Benefits.benefitInventory = 2023
        }
        Benefits.WEEKEND_DISCOUNT.setBonus(Benefits.benefitInventory)
        Assertions.assertEquals(Benefits.WEEKEND_DISCOUNT.getBonus(), price)
    }

    @CsvSource("120000:샴페인 1개", "55000:없음", delimiter = ':')
    @ParameterizedTest
    fun `증정메뉴 체크`(pay: Int, result: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            Bill.Pay.BEFORE_DISCOUNT.setPay(pay)
            if (Bill.Pay.BEFORE_DISCOUNT.getPay() >= 120000) {
                Benefits.GIFT_EVENT.setBonus(25000)
                println("샴페인 1개")
            } else {
                println("없음")
            }
            Assertions.assertEquals(output(), result)
        }
    }

    @CsvSource("5500:별", "10000:트리", "25000:산타", "4000:없음", delimiter = ':')
    @ParameterizedTest
    fun `이벤트 배지 체크`(pay: Int, result: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            when (pay) {
                in 20000..Int.MAX_VALUE -> println(EventBadge.SANTA.koreanText)
                in 10000..19999 -> println(EventBadge.TREE.koreanText)
                in 5000..9999 -> println(EventBadge.STAR.koreanText)
                else -> println("없음")
            }
            Assertions.assertEquals(output(), result)
        }
    }

    override fun runMain() {
        // 메인 호출하지 않음
    }
}