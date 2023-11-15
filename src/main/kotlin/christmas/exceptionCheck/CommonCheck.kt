package christmas.exceptionCheck

import christmas.view.OutputView

class CommonCheck {
    companion object {
        fun isClearSpace(inputResult: String, caseMessage: String): Boolean {
            require(inputResult.replace(" ", "") != "") {
                when (caseMessage) {
                    OutputView.REQUEST_DATE.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.dateMessage)
                        return true
                    }

                    OutputView.REQUEST_MENU.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }

        fun isBlank(inputResult: String, caseMessage: String): Boolean {
            require(inputResult.isNotBlank()) {
                when (caseMessage) {
                    OutputView.REQUEST_DATE.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.dateMessage)
                        return true
                    }

                    OutputView.REQUEST_MENU.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }

        fun isEmpty(inputResult: String, caseMessage: String): Boolean {
            require(inputResult.isNotEmpty()) {
                when (caseMessage) {
                    OutputView.REQUEST_DATE.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.dateMessage)
                        return true
                    }

                    OutputView.REQUEST_MENU.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }

        fun isNull(inputResult: String, caseMessage: String): Boolean {
            require(!inputResult.isNullOrEmpty() || !inputResult.isNullOrBlank()) {
                when (caseMessage) {
                    OutputView.REQUEST_DATE.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.dateMessage)
                        return true
                    }

                    OutputView.REQUEST_MENU.toString() -> {
                        OutputView.throwIllegalArgumentException(CheckSystem.menuMessage)
                        return true
                    }
                }
                return false
            }
            return false
        }
    }
}