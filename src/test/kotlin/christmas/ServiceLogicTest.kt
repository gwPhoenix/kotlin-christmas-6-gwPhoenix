package christmas


import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.restaurant.Bill
import christmas.view.InputView
import christmas.view.InputView.Companion.saveDate
import christmas.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class ServiceLogicTest : NsTest() {
    @ValueSource(
        strings = ["안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.",
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
            "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (ex.크리스마스파스타-2, 제로콜라-2)",
            "==========12월 5일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!=========="
        ]
    )

    @CsvSource("1:1", "15:15", "22:22", "31:31", delimiter = ':')
    @ParameterizedTest
    fun `날짜 저장이 잘되는지`(ints1: Int, ints2: Int) {
        Assertions.assertSimpleTest {
            saveDate(ints1)
            assertEquals(InputView.orderDate, ints2)
        }
    }

    @CsvSource(
        "1000:1,000원",
        "10000:10,000원",
        "100000:100,000원",
        "1000000:1,000,000원",
        delimiter = ':'
    )
    @ParameterizedTest
    fun `3자리 단위로 금액이 잘 출력되는지`(ints: Int, str: String) {
        assertEquals(OutputView.priceFormat(ints), str)
    }

    override fun runMain() {
        // main 호출하지 않음
    }
}


