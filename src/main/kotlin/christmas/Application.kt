package christmas




fun main() {
    Output.getMessage(Output.REQUEST_DATA.toString())
    Input.result = Input.fromUser()

    println("입력값 : ${Input.result}")
}
