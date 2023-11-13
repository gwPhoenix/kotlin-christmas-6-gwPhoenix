package christmas

enum
class Appetizer(private val koreanText: String, private val price: Int) {
    MUSHROOM_SOUP("양송이스프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    companion object {

        fun allMenu():String{
            return "${MUSHROOM_SOUP.koreanText}, ${TAPAS.koreanText}, ${CAESAR_SALAD.koreanText}"

        }
        fun getMushroomSoup(): String {
            return MUSHROOM_SOUP.koreanText
        }

        fun getMushroomSoupPrice(): Int {
            return MUSHROOM_SOUP.price
        }

        fun getTapas(): String {
            return TAPAS.koreanText
        }

        fun getTapasPrice(): Int {
            return TAPAS.price
        }

        fun getCaesarSalad(): String {
            return CAESAR_SALAD.koreanText
        }

        fun getCaesarSaladPrice(): Int {
            return CAESAR_SALAD.price
        }
    }
}