package christmas

enum class MenuCategory(private val koreanMunuText: String) {

    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");

    companion object {
        fun getAppetizer(): String {
            return APPETIZER.koreanMunuText
        }

        fun getMain(): String {
            return MAIN.koreanMunuText
        }

        fun getDessert(): String {
            return DESSERT.koreanMunuText
        }

        fun getDrink(): String {
            return DRINK.koreanMunuText
        }

    }
}








