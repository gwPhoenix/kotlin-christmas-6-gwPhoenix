package christmas

enum class MenuCategory(private val koreanText: String) {

    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");

    companion object {

        fun getAppetizer(): String {
            return APPETIZER.koreanText
        }

        fun getMain(): String {
            return MAIN.koreanText
        }

        fun getDessert(): String {
            return DESSERT.koreanText
        }

        fun getDrink(): String {
            return DRINK.koreanText
        }

    }
}








