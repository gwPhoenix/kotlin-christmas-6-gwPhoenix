package christmas

class MenuCheck {

    companion object {

        private val menuCheckRegularExpression = Regex("""^[가-힣]+-\d+(,\s*[가-힣]+-\d+)*$""")
        private val orderMenu = mutableListOf<String>()

        private var MenuBoard = mutableListOf<String>()
        private var allDrink = mutableListOf<String>()
        private var temporaryMenu = ""
        fun formCheck(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.matches(menuCheckRegularExpression)) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun getMenuBoard() {
            MenuBoard.clear()
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

        fun realMenu(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            orderMenu.clear() // 초기화
            for (clue in menu.keys) {
                orderMenu.add(clue)
            }

            require(orderMenu.intersect(MenuBoard).count() == orderMenu.size) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun repeatMenu(errorMessage: String): Boolean {
            require(Input.oderMenu.size == Input.orderMenuInventory.size) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun notOnlyDrink(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            allDrink.add(Drink.allMenu())
            temporaryMenu = allDrink.toString().replace("[", "")
            temporaryMenu = temporaryMenu.replace("]", "")
            temporaryMenu = temporaryMenu.replace(" ", "")
            allDrink = temporaryMenu.split(",").toMutableList()

            orderMenu.clear() // 초기화
            for (clue in menu.keys) {
                orderMenu.add(clue)
            }
            println("카운트 : ${orderMenu.intersect(allDrink).count()}")
            println("사이즈 : ${orderMenu.size}")
            println("체크 : ${orderMenu.intersect(allDrink).count() == orderMenu.size}")


            require(orderMenu.intersect(allDrink).count() != orderMenu.size) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}