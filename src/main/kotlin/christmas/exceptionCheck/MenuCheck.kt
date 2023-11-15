package christmas.exceptionCheck

import christmas.restaurant.Menu
import christmas.view.InputView
import christmas.view.OutputView

class MenuCheck {

    companion object {

        private val menuCheckRegularExpression = Regex("""^[가-힣]+-\d+(,\s*[가-힣]+-\d+)*$""")
        private val orderMenu = mutableListOf<String>()

        private var MenuBoard = mutableListOf<String>()
        private var allDrink = mutableListOf<String>()
        private var temporaryMenu = ""
        fun formCheck(inputResult: String, errorMessage: String): Boolean {
            require(inputResult.matches(menuCheckRegularExpression)) {
                OutputView.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun getMenuBoard() {
            MenuBoard.clear()

            MenuBoard.add(Menu.Drink.getAllDrink())
            MenuBoard.add(Menu.Appetizer.getAllAppetizer())
            MenuBoard.add(Menu.MainMenu.getAllMain())
            MenuBoard.add(Menu.Dessert.getAllDessert())

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
                OutputView.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun repeatMenu(errorMessage: String): Boolean {
            require(InputView.oderMenu.size == InputView.orderMenuInventory.size) {
                OutputView.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun notOnlyDrink(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            allDrink.add(Menu.Drink.getAllDrink().toString())
            temporaryMenu = allDrink.toString().replace("[", "")
            temporaryMenu = temporaryMenu.replace("]", "")
            temporaryMenu = temporaryMenu.replace(" ", "")
            allDrink = temporaryMenu.split(",").toMutableList()

            orderMenu.clear()
            for (clue in menu.keys) {
                orderMenu.add(clue)
            }
            require(orderMenu.intersect(allDrink).count() != orderMenu.size) {
                OutputView.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }

        fun zero(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            for (clue in menu.keys) {
                require(menu[clue].toString().toIntOrNull() != 0) {
                    OutputView.throwIllegalArgumentException(errorMessage)
                    return true
                }
            }
            return false
        }

        fun overTwenty(menu: MutableMap<String, Int>, errorMessage: String): Boolean {
            InputView.menuQuantity = 0
            for (clue in menu.keys) {
                InputView.menuQuantity += menu[clue]!!.toInt()
            }
            require(InputView.menuQuantity in 1..20) {
                OutputView.throwIllegalArgumentException(errorMessage)
                return true
            }
            return false
        }
    }
}