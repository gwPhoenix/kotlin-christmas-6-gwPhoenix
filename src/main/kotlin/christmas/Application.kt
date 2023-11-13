package christmas

import christmas.CheckSystem.Companion.keepOn


fun main() {
    Output.startMessage()
    while (keepOn) {
        Output.getMessage(Output.REQUEST_DATE.toString())
        Input.result = Input.fromUser()
        keepOn = CheckSystem.start(Input.result, Output.REQUEST_DATE.toString(), CheckSystem)
        CheckSystem.checkResult = false // 오류 체크 상태값 다시 초기화
    }
    Output.displayMenu()
    while (keepOn) {
        Output.getMessage(Output.REQUEST_MENU.toString())
        Input.result = Input.fromUser()
        keepOn = CheckSystem.start(Input.result, Output.REQUEST_MENU.toString(), CheckSystem)
        CheckSystem.checkResult = false // 오류 체크 상태값 다시 초기화
    }
}


