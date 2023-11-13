package christmas

class DateCheck {
    companion object {
        fun notNumber(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.toIntOrNull() != null) {
                Output.throwNumberFormatException(errorMessage)
                return true
            }
            return false
        }

        fun not1To31(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.toIntOrNull() in 1..31) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}