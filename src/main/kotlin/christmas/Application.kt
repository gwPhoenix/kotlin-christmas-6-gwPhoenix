package christmas

import christmas.exceptionCheck.CheckSystem
import christmas.exceptionCheck.CheckSystem.Companion.keepOn
import christmas.view.InputView
import christmas.view.OutputView


fun main() {
    OutputView.startMessage()
    while (keepOn) {
        OutputView.getMessage(OutputView.REQUEST_DATE.toString())
        InputView.result = InputView.fromUser()
        keepOn = CheckSystem.start(InputView.result, OutputView.REQUEST_DATE.toString(), CheckSystem)
        CheckSystem.checkResult = false // 오류 체크 상태값 다시 초기화
    }
    OutputView.displayMenu()
    while (keepOn) {
        OutputView.getMessage(OutputView.REQUEST_MENU.toString())
        InputView.result = InputView.fromUser()
        keepOn = CheckSystem.start(InputView.result, OutputView.REQUEST_MENU.toString(), CheckSystem)
        CheckSystem.checkResult = false // 오류 체크 상태값 다시 초기화
    }
    OutputView.displayBill()

}


