package christmas

enum class MenuCategory(private val menuText: String) {

    APPETIZER("애피타이저"),
    MAIN_MENU("메인"),
    DESSERT("디저트"),
    DRINK("음료");

    companion object {

        fun getCategory(menuCategory: MenuCategory): String {
            return menuCategory.menuText
        }
    }
}








