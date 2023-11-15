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


