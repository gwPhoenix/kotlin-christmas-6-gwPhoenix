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

            MenuBoard.add(Menu.Drink.getallDrink())
            MenuBoard.add(Menu.Appetizer.getallAppetizer())
            MenuBoard.add(Menu.MainMenu.getallMain())
            MenuBoard.add(Menu.Dessert.getallDessert())

            // intersect 적용되지 않아, 리스트 재변환
            temporaryMenu = MenuBoard.toString().replace("[", "")
            temporaryMenu = temporaryMenu.replace("]", "")
            temporaryMenu = temporaryMenu.replace(" ", "")
            MenuBoard = temporaryMenu.split(",").toMutableList()
        }

        fun realMenu(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            orderMenu.clear()
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
            allDrink.add(Menu.Drink.getallDrink().toString())
            temporaryMenu = allDrink.toString().replace("[", "")
            temporaryMenu = temporaryMenu.replace("]", "")
            temporaryMenu = temporaryMenu.replace(" ", "")
            allDrink = temporaryMenu.split(",").toMutableList()

            orderMenu.clear()
            for (clue in menu.keys) {
                orderMenu.add(clue)
            }
            require(orderMenu.intersect(allDrink).count() != orderMenu.size) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun zero(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            for (clue in menu.keys) {
                require(menu[clue].toString().toIntOrNull() != 0) {
                    Output.throwIllegalArgumentException(errorMessage)
                    return true
                }
            }
            return false
        }

        fun overTwenty(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            Input.menuQuantity = 0
            for (clue in menu.keys) {
                Input.menuQuantity += menu[clue]!!.toInt()
            }

            println("총 메뉴갯수 : ${Input.menuQuantity}")
            require(Input.menuQuantity in 1..20) {
                Output.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}