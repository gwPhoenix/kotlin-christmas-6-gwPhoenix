package christmas

import christmas.CheckSystem.Companion.keepOn


fun main() {
    Output.startMessage()
    while (keepOn) {
        Output.getMessage(Output.REQUEST_DATA.toString())
        Input.result = Input.fromUser()
        keepOn = CheckSystem.start(Input.result, Output.REQUEST_DATA.toString(), CheckSystem)
    }
}


