package christmas

enum class Drink(private val koreanMenuText: String, private val price: Int) {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    companion object {
        fun getZeroCola(): String {
            return ZERO_COLA.koreanMenuText
        }
        fun getZeroColaPrice(): Int {
            return ZERO_COLA.price
        }

        fun getRedWine(): String {
            return RED_WINE.koreanMenuText
        }
        fun getRedWinePrice(): Int {
            return RED_WINE.price
        }

        fun getChampagne(): String {
            return CHAMPAGNE.koreanMenuText
        }

        fun getChampagnePrice(): Int {
            return CHAMPAGNE.price
        }
    }
}