package christmas

class Menu() {
    enum class Main(private val koreanText: String, private val price: Int) {
        T_BONE_STEAK("티본스테이크", 55000),
        BBQ_LIP("바비큐립", 54000),
        SEAFOOD_PASTA("해산물파스타", 35000),
        X_MAS_PASTA("크리스마스파스타", 25000);

        companion object {
            fun getKoreanMenu(mainMenu: Main): String {
                return mainMenu.koreanText
            }

            fun getPrice(mainMenu: Main): Int {
                return mainMenu.price
            }

            fun getallMain() {
                println("${Main.values()}")
            }

            fun getallMainAndPrice(): String {
                valueInventory = ""
                round = 0
                for (mainVal in Main.values()) {
                    if (round < Main.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += "${mainVal.koreanText}(${mainVal.price})"
                    round++
                }
                return valueInventory
            }
        }
    }

    enum class Drink(private val koreanText: String, private val price: Int) {
        ZERO_COLA("제로콜라", 3000),
        RED_WINE("레드와인", 60000),
        CHAMPAGNE("샴페인", 25000);

        companion object {
            fun getKoreanMenu(drink: Drink): String {
                return drink.koreanText
            }

            fun getPrice(drink: Drink): Int {
                return drink.price
            }

            fun getallDrink() {
                println("${Drink.values()}")
            }

            fun getallDrinkAndPrice(): String {
                valueInventory = ""
                round = 0
                for (drinkVal in Drink.values()) {
                    if (round < Drink.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += "${drinkVal.koreanText}(${drinkVal.price})"
                    round++
                }
                return valueInventory
            }
        }
    }

    enum class Dessert(private val koreanText: String, private val price: Int) {
        CHOCOLATE_CAKE("초코케이크", 15000),
        ICE_CREAM("아이스크림", 5000);

        companion object {
            fun getKoreanMenu(dessert: Dessert): String {
                return dessert.koreanText
            }

            fun getPrice(dessert: Dessert): Int {
                return dessert.price

            }

            fun getallDessert() {
                println("${Dessert.values()}")
            }

            fun getallDessertAndPrice(): String {
                valueInventory = ""
                round = 0
                for (dessertVal in Dessert.values()) {
                    if (round < Dessert.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += "${dessertVal.koreanText}(${dessertVal.price})"
                    round++
                }
                return valueInventory
            }
        }
    }

    enum class Appetizer(private val koreanText: String, private val price: Int) {
        MUSHROOM_SOUP("양송이스프", 6000),
        TAPAS("타파스", 5500),
        CAESAR_SALAD("시저샐러드", 8000);

        companion object {
            fun getKoreanMenu(appetizer: Appetizer): String {
                return appetizer.koreanText
            }

            fun getPrice(appetizer: Appetizer): Int {
                return appetizer.price
            }

            fun getallAppetizer() {
                println("${Appetizer.values()}")
            }

            fun getallAppetizerAndPrice(): String {
                valueInventory = ""
                round = 0
                for (appetizerVal in Appetizer.values()) {
                    if (round < Appetizer.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += "${appetizerVal.koreanText}(${appetizerVal.price})"
                    round++
                }
                return valueInventory
            }
        }
    }

    companion object {
        private var valueInventory = ""
        private var round = 0
    }
}







