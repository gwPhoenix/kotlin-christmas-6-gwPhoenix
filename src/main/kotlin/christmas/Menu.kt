package christmas

import christmas.Bill.Companion.beforeDiscountPay

class Menu() {

    enum class Appetizer(private val koreanText: String, private val price: Int) {
        MUSHROOM_SOUP("양송이스프", 6000),
        TAPAS("타파스", 5500),
        CAESAR_SALAD("시저샐러드", 8000);

        companion object {
            var appetizerInventoryText = ""
            var appetizerInventory = mutableListOf<String>()

            fun getKoreanMenu(appetizer: Appetizer): String {
                return appetizer.koreanText
            }

            fun getPrice(searchKeword: String): Int {
                for (appetizerValues in Appetizer.values()) {
                    if (appetizerValues.koreanText == searchKeword) {
                        return appetizerValues.price
                    }
                }
                return 0
            }

            fun getallAppetizer(): String {
                valueInventory = ""
                round = 0
                for (appetizerVal in Appetizer.values()) {
                    if (round < Appetizer.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += appetizerVal.koreanText
                    round++
                }
                return valueInventory
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

            fun getDrinkDessertInventory(): Int {
                for (clue in Input.orderMenuInventory.keys) {
                    appetizerInventoryText = Drink.getallDrink()
                    Dessert.dessertInventoryText = appetizerInventoryText.replace(" ", "")
                    appetizerInventory = appetizerInventoryText.split(",").toMutableList()

                    if (clue.split(",").intersect(appetizerInventory).isNotEmpty()) {
                        beforeDiscountPay += Drink.getPrice(clue)
                    }
                }
                return beforeDiscountPay
            }

            fun searchMenu(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += Appetizer.getPrice(searchKeword)
                return beforeDiscountPay
            }
        }
    }

    enum class MainMenu(private val koreanText: String, private val price: Int) {
        T_BONE_STEAK("티본스테이크", 55000),
        BBQ_LIP("바비큐립", 54000),
        SEAFOOD_PASTA("해산물파스타", 35000),
        X_MAS_PASTA("크리스마스파스타", 25000);


        companion object {
            var mainInventoryText = ""
            var mainInventory = mutableListOf<String>()

            fun getKoreanMenu(mainMenu: MainMenu): String {
                return mainMenu.koreanText
            }

            fun getPrice(searchKeword: String): Int {
                for (mainValues in MainMenu.values()) {
                    if (mainValues.koreanText == searchKeword) {
                        return mainValues.price
                    }
                }
                return 0
            }

            fun getallMain(): String {
                valueInventory = ""
                round = 0
                for (mainVal in MainMenu.values()) {
                    if (round < MainMenu.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += mainVal.koreanText
                    round++
                }
                return valueInventory
            }

            fun getallMainAndPrice(): String {
                valueInventory = ""
                round = 0
                for (mainVal in MainMenu.values()) {
                    if (round < MainMenu.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += "${mainVal.koreanText}(${mainVal.price})"
                    round++
                }
                return valueInventory
            }

            fun getMainInventory(): Int {
                for (clue in Input.orderMenuInventory.keys) {
                    mainInventoryText = MainMenu.getallMain()
                    mainInventoryText = mainInventoryText.replace(" ", "")
                    mainInventory = mainInventoryText.split(",").toMutableList()

                    if (clue.split(",").intersect(mainInventory).isNotEmpty()) {
                        beforeDiscountPay += MainMenu.getPrice(clue)
                    }
                }
                return beforeDiscountPay
            }

            fun searchMenu(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += MainMenu.getPrice(searchKeword)
                return beforeDiscountPay
            }
        }
    }

    enum class Drink(private val koreanText: String, private val price: Int) {
        ZERO_COLA("제로콜라", 3000),
        RED_WINE("레드와인", 60000),
        CHAMPAGNE("샴페인", 25000);

        companion object {
            var drinkInventoryText = ""
            var drinkInventory = mutableListOf<String>()

            fun getKoreanMenu(drink: Drink): String {
                return drink.koreanText
            }

            fun getPrice(searchKeword: String): Int {
                for (drinkValues in Drink.values()) {
                    if (drinkValues.koreanText == searchKeword) {
                        return drinkValues.price
                    }
                }
                return 0
            }

            fun getallDrink(): String {
                valueInventory = ""
                round = 0
                for (drinkVal in Drink.values()) {
                    if (round < Drink.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += drinkVal.koreanText
                    round++
                }
                return valueInventory
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

            fun getDrinkInventory(): Int {
                for (clue in Input.orderMenuInventory.keys) {
                    drinkInventoryText = Drink.getallDrink()
                    drinkInventoryText = drinkInventoryText.replace(" ", "")
                    drinkInventory = drinkInventoryText.split(",").toMutableList()

                    if (clue.split(",").intersect(MainMenu.mainInventory).isNotEmpty()) {
                        beforeDiscountPay += Drink.getPrice(clue)
                    }
                }
                return beforeDiscountPay
            }

            fun searchMenu(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += Drink.getPrice(searchKeword)
                return beforeDiscountPay
            }

        }
    }

    enum class Dessert(private val koreanText: String, private val price: Int) {
        CHOCOLATE_CAKE("초코케이크", 15000),
        ICE_CREAM("아이스크림", 5000);

        companion object {
            var dessertInventoryText = ""
            var dessertInventory = mutableListOf<String>()

            fun getKoreanMenu(dessert: Dessert): String {
                return dessert.koreanText
            }

            fun getPrice(searchKeword: String): Int {
                for (dessertValues in entries) {
                    println("여기 들어온거야 그거1")
                    if (dessertValues.koreanText == searchKeword) {
                        println("여기 들어온거야 그거2")
                        return dessertValues.price
                    }
                }
                return 0
            }

            fun getallDessert(): String {
                valueInventory = ""
                round = 0
                for (dessertVal in Dessert.values()) {
                    if (round < Dessert.values().size && round > 0) {
                        valueInventory += ", "
                    }
                    valueInventory += dessertVal.koreanText
                    round++
                }
                return valueInventory
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

            fun getDrinkDessertInventory(): Int {
                for (clue in Input.orderMenuInventory.keys) {
                    dessertInventoryText = Drink.getallDrink()
                    dessertInventoryText = dessertInventoryText.replace(" ", "")
                    dessertInventory = dessertInventoryText.split(",").toMutableList()

                    if (clue.split(",").intersect(dessertInventory).isNotEmpty()) {
                        beforeDiscountPay += Drink.getPrice(clue)
                    }
                }
                return beforeDiscountPay
            }

            fun searchMenu(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += Dessert.getPrice(searchKeword)
                return beforeDiscountPay
            }
        }

    }

    companion object {
        private var valueInventory = ""
        private var round = 0
    }
}







