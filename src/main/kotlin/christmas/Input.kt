package christmas

import camp.nextstep.edu.missionutils.Console

class Input {
    companion object {
        var result = ""
        var orderDate = 0
        var oderMenu = mutableSetOf<String>()
        var orderMenuInventory = mutableMapOf<String, Int>()
        fun fromUser(): String {
            result = Console.readLine()
            return result
        }

        fun saveDate(date: Int) {
            orderDate = date
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
    }
}

