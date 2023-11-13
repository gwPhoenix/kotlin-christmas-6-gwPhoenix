package christmas

enum class Dessert(private val koreanMenuText: String, private val price: Int) {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    companion object {
        fun getChocolateCake(): String {
            return CHOCOLATE_CAKE.koreanMenuText
        }

        fun getChocolateCakePrice(): Int {
            return CHOCOLATE_CAKE.price
        }

        fun getIceCream(): String {
            return ICE_CREAM.koreanMenuText
        }

        fun getIceCreamPrice(): Int {
            return ICE_CREAM.price
        }
    }
}