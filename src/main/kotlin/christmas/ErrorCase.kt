package christmas

import christmas.CheckSystem.Companion.checkResult

class ErrorCase {
    companion object {

        fun commonCheck(
            inputResult: String, caseMessage: String, checkSys: CheckSystem.Companion
        ): Boolean {
            if (!checkResult) {
                checkResult = CommonCheck.isGap(inputResult, caseMessage, checkSys)
            }
            if (!checkResult) {
                checkResult = CommonCheck.isBlank(inputResult, caseMessage, checkSys)
            }
            if (!checkResult) {
                checkResult = CommonCheck.isEmpty(inputResult, caseMessage, checkSys)
            }
            if (!checkResult) {
                checkResult = CommonCheck.isNull(inputResult, caseMessage, checkSys)
            }
            return checkResult
        }


        fun dateCheck(
            inputResult: String, checkResult: Boolean, errorMessage: String
        ): Boolean {
            /*CheckSystem.checkResult =
                DateCheck.notNumber(inputResult, CheckSystem.checkResult, CheckSystem.dateMessage)
            return CheckSystem.checkResult*/
            TODO("작업중")
        }

        fun menuCheck(
            inputResult: String, checkResult: Boolean, errorMessage: String
        ): Boolean {
            TODO("작업중")
        }
    }
}




