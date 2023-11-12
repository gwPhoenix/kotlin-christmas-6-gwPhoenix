package christmas

import camp.nextstep.edu.missionutils.Console

class Input {
    companion object {
        var result = ""
        fun fromUser(): String {
            result = Console.readLine()
            return result
        }
    }
}

