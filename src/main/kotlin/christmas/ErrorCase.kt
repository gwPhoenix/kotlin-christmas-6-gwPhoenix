package christmas

import christmas.CheckSystem.Companion.checkResult

class ErrorCase {
    companion object {
        fun commonCheck(
            inputResult: String, caseMessage: String, checkSys: CheckSystem.Companion
        ): Boolean {
            if (!checkResult) {
                checkResult = CommonCheck.isClearSpace(inputResult, caseMessage, checkSys)
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
            if (!checkResult) {
                CheckSystem.checkResult =
                    DateCheck.notNumber(inputResult, errorMessage)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult =
                    DateCheck.not1To31(inputResult, errorMessage)
            }
            return CheckSystem.checkResult
        }

        fun menuCheck(
            inputResult: String, checkResult: Boolean, errorMessage: String
        ): Boolean {
            if (!checkResult) {
                CheckSystem.checkResult =
                    MenuCheck.formCheck(inputResult, errorMessage)
            }
            return CheckSystem.checkResult
        }
    }
}




