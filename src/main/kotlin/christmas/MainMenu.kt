package christmas

enum class MainMenu(private val koreanText: String, private val price: Int) {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_LIP("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    X_MAS_PASTA("크리스마스파스타", 25000);

    companion object {

        fun allMenu(): String {
            return "${T_BONE_STEAK.koreanText}, ${BBQ_LIP.koreanText}, " +
                    "${SEAFOOD_PASTA.koreanText}, ${X_MAS_PASTA.koreanText}"
        }


        fun getTboneSteak(): String {
            return T_BONE_STEAK.koreanText
        }

        fun getTboneSteakPrice(): Int {
            return T_BONE_STEAK.price
        }

        fun getBBQLip(): String {
            return BBQ_LIP.koreanText
        }

        fun getBBQLipPrice(): Int {
            return BBQ_LIP.price
        }

        fun getSeafoodPasta(): String {
            return SEAFOOD_PASTA.koreanText
        }

        fun getSeafoodPastaPrice(): Int {
            return SEAFOOD_PASTA.price
        }

        fun getXmasPasta(): String {
            return X_MAS_PASTA.koreanText
        }

        fun getXmasPastaPrice(): Int {
            return X_MAS_PASTA.price
        }
    }
}