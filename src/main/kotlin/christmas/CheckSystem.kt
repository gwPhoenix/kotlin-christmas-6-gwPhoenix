package christmas

class CheckSystem(private var inputResult: String, private var caseMessage: String) {
    companion object {
        var keepOn = true
        var checkResult = false

        var dateMessage = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
        var menuMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."

        fun start(inputResult: String, caseMessage: String, checkSys: Companion): Boolean {
            checkResult = ErrorCase.commonCheck(inputResult, caseMessage, checkSys)
            if (checkResult) {
                return true
            } else {
                when (caseMessage) {
                    Output.REQUEST_DATE.toString() ->
                        checkResult =
                            ErrorCase.dateCheck(inputResult, checkResult, checkSys.dateMessage)

                    Output.REQUEST_MENU.toString() -> checkResult =
                        ErrorCase.menuCheck(inputResult, checkResult, checkSys.menuMessage)
                }
                return checkResult
            }
        }
    }
}


