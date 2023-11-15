package christmas.exceptionCheck

import christmas.view.OutputView

class DateCheck {
    companion object {
        fun notNumber(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.toIntOrNull() != null) {
                OutputView.throwNumberFormatException(errorMessage)
                return true
            }
            return false
        }

        fun not1To31(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.toIntOrNull() in 1..31) {
                OutputView.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}