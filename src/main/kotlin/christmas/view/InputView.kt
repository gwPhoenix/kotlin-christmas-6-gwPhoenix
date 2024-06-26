package christmas.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    companion object {
        var result = ""
        var orderDate = 0
        var oderMenu = mutableSetOf<String>()
        var orderMenuInventory = mutableMapOf<String, Int>()
        var menuQuantity = 0

        fun fromUser(): String {
            result = Console.readLine()
            return result
        }

        fun toCatalog(inputResult: String): MutableSet<String> {
            oderMenu = inputResult.replace(" ","").split(",").toMutableSet()
            return oderMenu
        }

        fun catalogToLookupTable(catalog: MutableSet<String>): MutableMap<String, Int> {
            for (menuAndNumber in catalog) {
                orderMenuInventory[menuAndNumber.split("-")[0]] =
                    menuAndNumber.split("-")[1].toInt()
            }
            return orderMenuInventory
        }

        fun saveDate(inputdate:Int) {
            orderDate = inputdate
        }
    }
}

