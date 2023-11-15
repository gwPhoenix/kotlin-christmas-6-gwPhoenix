package christmas.exceptionCheck

import christmas.exceptionCheck.CheckSystem.Companion.checkResult
import christmas.view.InputView

class ErrorCase {
    companion object {
        fun commonCheck(inputResult: String, caseMessage: String): Boolean {
            if (!checkResult) {
                checkResult = CommonCheck.isClearSpace(inputResult, caseMessage)
            }
            if (!checkResult) {
                checkResult = CommonCheck.isBlank(inputResult, caseMessage)
            }
            if (!checkResult) {
                checkResult = CommonCheck.isEmpty(inputResult, caseMessage)
            }
            if (!checkResult) {
                checkResult = CommonCheck.isNull(inputResult, caseMessage)
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
                InputView.saveDate(inputResult.toInt())
            }
            return CheckSystem.checkResult
        }

        fun menuCheck(inputResult: String, checkResult: Boolean, errorMessage: String): Boolean {
            if (!checkResult) {
                CheckSystem.checkResult = MenuCheck.formCheck(inputResult, errorMessage)
            }
            if (!CheckSystem.checkResult) {
                // 주문형식이 문제 없으면, 셋으로 변환 후 다시 맵으로 변환
                InputView.oderMenu.clear()
                InputView.oderMenu = InputView.toCatalog(inputResult)
                InputView.orderMenuInventory.clear()
                InputView.orderMenuInventory = InputView.catalogToLookupTable(InputView.oderMenu)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult = MenuCheck.repeatMenu(errorMessage)
            }

            if (!CheckSystem.checkResult) {
                MenuCheck.getMenuBoard()
                CheckSystem.checkResult =
                    MenuCheck.realMenu(InputView.orderMenuInventory, errorMessage)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult =
                    MenuCheck.notOnlyDrink(InputView.orderMenuInventory, errorMessage)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult = MenuCheck.zero(InputView.orderMenuInventory, errorMessage)
            }

            if (!CheckSystem.checkResult) {
                CheckSystem.checkResult =
                    MenuCheck.overTwenty(InputView.orderMenuInventory, errorMessage)
            }
            return CheckSystem.checkResult
        }
    }
}




