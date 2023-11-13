package christmas

enum class Dessert(private val koreanText: String, private val price: Int) {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    companion object {

        fun allMenu(): String {
            return "${CHOCOLATE_CAKE.koreanText}, ${ICE_CREAM.koreanText}"
        }

        fun getChocolateCake(): String {
            return CHOCOLATE_CAKE.koreanText
        }

        fun getChocolateCakePrice(): Int {
            return CHOCOLATE_CAKE.price
        }

        fun getIceCream(): String {
            return ICE_CREAM.koreanText
        }

        fun getIceCreamPrice(): Int {
            return ICE_CREAM.price
        }
    }
}