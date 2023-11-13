package christmas

class MenuCheck {

    companion object {

        private val menuCheckRegularExpression = Regex("""^[가-힣]+-\d+(,\s*[가-힣]+-\d+)*$""")
        private var MenuBoard = mutableListOf<String>()
        private val orderMenu = mutableListOf<String>()
        private var temporaryMenu = ""
        fun formCheck(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.matches(menuCheckRegularExpression)) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun getRealMenu() {
            MenuBoard.add(Drink.allMenu())
            MenuBoard.add(Appetizer.allMenu())
            MenuBoard.add(MainMenu.allMenu())
            MenuBoard.add(Dessert.allMenu())

            // intersect 적용되지 않아, 리스트 재변환
            temporaryMenu = MenuBoard.toString().replace("[", "")
            temporaryMenu = temporaryMenu.replace("]", "")
            temporaryMenu = temporaryMenu.replace(" ", "")
            MenuBoard = temporaryMenu.split(",").toMutableList()
        }

        fun realMenu(menu: MutableMap<String, Int>, errorMessage: String)
                : Boolean {
            orderMenu.clear() // 초기화
            for (clue in menu.keys) {
                orderMenu.add(clue)
            }

            println("메뉴판 : ${MenuBoard}")
            println("주문 : ${orderMenu}")
            println("카운트 : ${MenuBoard.intersect(orderMenu).count()}")
            println("사이즈 : ${menu.size}")


            if (orderMenu.intersect(MenuBoard).count() != orderMenu.size) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}