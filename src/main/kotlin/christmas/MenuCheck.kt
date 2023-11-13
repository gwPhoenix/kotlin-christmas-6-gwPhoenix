package christmas

class MenuCheck {

    companion object {

        private val menuCheckRegularExpression = Regex("""^[가-힣]+-\d+(,\s*[가-힣]+-\d+)*$""")
        fun formCheck(
            inputResult: String, errorMessage: String
        ): Boolean {
            require(inputResult.matches(menuCheckRegularExpression)){
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}