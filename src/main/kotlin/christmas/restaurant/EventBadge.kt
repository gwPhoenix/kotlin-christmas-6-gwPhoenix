package christmas.restaurant

enum class EventBadge(val koreanText: String, private val basePrice: Int) {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);
}