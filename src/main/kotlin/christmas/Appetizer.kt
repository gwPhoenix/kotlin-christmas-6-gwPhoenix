package christmas

enum
class Appetizer(private val koreanMenuText: String, private val price: Int) {
    MUSHROOM_SOUP("양송이스프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    companion object {
        fun getMushroomSoup(): String {
            return MUSHROOM_SOUP.koreanMenuText
        }

        fun getMushroomSoupPrice(): Int {
            return MUSHROOM_SOUP.price
        }

        fun getTapas(): String {
            return TAPAS.koreanMenuText
        }

        fun getTapasPrice(): Int {
            return TAPAS.price
        }

        fun getCaesarSalad(): String {
            return CAESAR_SALAD.koreanMenuText
        }

        fun getCaesarSaladPrice(): Int {
            return CAESAR_SALAD.price
        }
    }
}