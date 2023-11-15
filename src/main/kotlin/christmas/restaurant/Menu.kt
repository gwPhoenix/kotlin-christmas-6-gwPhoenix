package christmas.restaurant

import christmas.restaurant.Bill.Companion.beforeDiscountPay
import christmas.view.InputView.Companion.orderMenuInventory

class Menu() {

    enum class Appetizer(private val koreanText: String, private val price: Int) {
        MUSHROOM_SOUP("양송이스프", 6000),
        TAPAS("타파스", 5500),
        CAESAR_SALAD("시저샐러드", 8000);

        companion object {
            fun getKoreanMenu(appetizer: Appetizer): String {
                return appetizer.koreanText
            }

            private fun getPrice(searchKeword: String): Int {
                for (appetizerValues in Appetizer.values()) {
                    if (appetizerValues.koreanText == searchKeword) {
                        return appetizerValues.price
                    }
                }
                return 0
            }

            fun getAllAppetizer(): String {
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

            fun getAllAppetizerAndPrice(): String {
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


            fun searchMenuPrice(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += getPrice(searchKeword)
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
            var mainBenefitsAmount = 0

            fun getPrice(searchKeword: String): Int {
                for (mainValues in MainMenu.values()) {
                    if (mainValues.koreanText == searchKeword) {
                        return mainValues.price
                    }
                }
                return 0
            }

            fun getAllMain(): String {
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

            fun getAllMainAndPrice(): String {
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

            fun searchMenuPrice(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += getPrice(searchKeword)
                return beforeDiscountPay
            }

            fun getMainInventory(): Int {
                mainInventoryText = ""
                mainInventory.clear()
                mainBenefitsAmount = 0

                mainInventoryText = getAllMain()
                mainInventoryText = mainInventoryText.replace(" ", "")
                mainInventory = mainInventoryText.split(",").toMutableList()
                for (clue in mainInventory) {
                    mainBenefitsAmount += checkMainInventory(clue)
                }
                return mainBenefitsAmount
            }

            private fun checkMainInventory(searchKey: String): Int {
                mainBenefitsAmount = 0
                for (clue in orderMenuInventory.keys) {
                    if (clue == searchKey) {
                        mainBenefitsAmount += orderMenuInventory[clue]!!
                    }
                }
                return mainBenefitsAmount
            }
        }
    }

    enum class Drink(private val koreanText: String, private val price: Int) {
        ZERO_COLA("제로콜라", 3000),
        RED_WINE("레드와인", 60000),
        CHAMPAGNE("샴페인", 25000);

        companion object {

            private fun getPrice(searchKeword: String): Int {
                for (drinkValues in Drink.values()) {
                    if (drinkValues.koreanText == searchKeword) {
                        return drinkValues.price
                    }
                }
                return 0
            }

            fun getAllDrink(): String {
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

            fun getAllDrinkAndPrice(): String {
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

            fun searchMenuPrice(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += getPrice(searchKeword)
                return beforeDiscountPay
            }

        }
    }

    enum class Dessert(private val koreanText: String, private val price: Int) {
        CHOCOLATE_CAKE("초코케이크", 15000),
        ICE_CREAM("아이스크림", 5000);

        companion object {
            private var dessertInventoryText = ""
            private var dessertInventory = mutableListOf<String>()
            private var dessertBenefitsAmount = 0

            private fun getPrice(searchKeword: String): Int {
                for (dessertValues in entries) {
                    if (dessertValues.koreanText == searchKeword) {
                        return dessertValues.price
                    }
                }
                return 0
            }

            fun getAllDessert(): String {
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

            fun getAllDessertAndPrice(): String {
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

            fun getDessertInventory(): Int {
                dessertInventory.clear()
                dessertBenefitsAmount = 0

                dessertInventoryText = getAllDessert()
                dessertInventoryText = dessertInventoryText.replace(" ", "")
                dessertInventory = dessertInventoryText.split(",").toMutableList()
                for (clue in dessertInventory) {
                    dessertBenefitsAmount += checkDessertInventory(clue)
                }
                return dessertBenefitsAmount
            }

            private fun checkDessertInventory(searchKey: String): Int {
                Dessert.dessertBenefitsAmount = 0
                for (clue in orderMenuInventory.keys) {
                    if (clue == searchKey) {
                        dessertBenefitsAmount += orderMenuInventory[clue]!!
                    }
                }
                return dessertBenefitsAmount
            }

            fun searchMenuPrice(searchKeword: String): Int {
                beforeDiscountPay = 0
                beforeDiscountPay += getPrice(searchKeword)
                return beforeDiscountPay
            }
        }

    }

    companion object {
        private var valueInventory = ""
        private var round = 0
    }
}







