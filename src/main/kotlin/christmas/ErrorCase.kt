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
                CheckSystem.checkResult = DateCheck.notNumber(inputResult, errorMessage)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult = DateCheck.not1To31(inputResult, errorMessage)
            }

            if (!CheckSystem.checkResult) {
                // 날짜=숫자가 이상없으면, 해당 날짜 저장
                Input.saveDate(inputResult.toInt())
            }
            return CheckSystem.checkResult
        }

        fun menuCheck(inputResult: String, checkResult: Boolean, errorMessage: String): Boolean {
            if (!checkResult) {
                CheckSystem.checkResult = MenuCheck.formCheck(inputResult, errorMessage)
            }
            if (!CheckSystem.checkResult) {
                // 주문형식이 문제 없으면, 셋으로 변환 후 다시 맵으로 변환
                Input.oderMenu = Input.toCatalog(inputResult)
                Input.orderMenuInventory.clear() // 초기화
                Input.orderMenuInventory = Input.catalogToLookupTable(Input.oderMenu)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult = MenuCheck.repeatMenu(errorMessage)
            }

            if (!CheckSystem.checkResult) {
                MenuCheck.getMenuBoard()
                CheckSystem.checkResult = MenuCheck.realMenu(Input.orderMenuInventory, errorMessage)
            }

            if(!CheckSystem.checkResult) {
                CheckSystem.checkResult = MenuCheck.notOnlyDrink(Input.orderMenuInventory, errorMessage)
            }
            println("맵 : ${Input.orderMenuInventory}")
            return CheckSystem.checkResult
        }
    }
}




