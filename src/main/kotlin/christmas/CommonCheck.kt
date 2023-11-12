package christmas

class CommonCheck {
    companion object{
        fun isGap(
            inputResult: String, caseMessage: String, checksys: CheckSystem.Companion
        ): Boolean {
            require(inputResult.replace(" ", "") != "") {
                when (caseMessage) {
                    Output.REQUEST_DATA.toString() -> {
                        Output.throwIllegalArgumentException(checksys.dateMessage)
                        println("여기서 잡히는건가")
                        return true
                    }

                    Output.REQUEST_MENU.toString() -> {
                        Output.throwIllegalArgumentException(checksys.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }

        fun isBlank(
            inputResult: String, caseMessage: String, checksys: CheckSystem.Companion
        ): Boolean {
            require(inputResult.isNotBlank()) {
                when (caseMessage) {
                    Output.REQUEST_DATA.toString() -> {
                        Output.throwIllegalArgumentException(checksys.dateMessage)
                        return true
                    }

                    Output.REQUEST_MENU.toString() -> {
                        Output.throwIllegalArgumentException(checksys.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }

        fun isEmpty(
            inputResult: String, caseMessage: String, checksys: CheckSystem.Companion
        ): Boolean {
            require(inputResult.isNotEmpty()) {
                when (caseMessage) {
                    Output.REQUEST_DATA.toString() -> {
                        Output.throwIllegalArgumentException(checksys.dateMessage)
                        return true
                    }

                    Output.REQUEST_MENU.toString() -> {
                        Output.throwIllegalArgumentException(checksys.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }

        fun isNull(inputResult: String, caseMessage: String, checksys: CheckSystem.Companion
        ): Boolean {
            require(!inputResult.isNullOrEmpty() || !inputResult.isNullOrBlank()) {
                when (caseMessage) {
                    Output.REQUEST_DATA.toString() -> {
                        Output.throwIllegalArgumentException(checksys.dateMessage)
                        return true
                    }

                    Output.REQUEST_MENU.toString() -> {
                        Output.throwIllegalArgumentException(checksys.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }
    }
}