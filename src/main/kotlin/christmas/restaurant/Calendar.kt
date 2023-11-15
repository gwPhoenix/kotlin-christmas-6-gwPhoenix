package christmas.restaurant

import java.time.DayOfWeek
import java.time.LocalDate


class Calendar {
    enum class StarEvent(val dayNumber: Int) {
        THREE(3), TEN(10),
        SEVENTEEN(17),
        TWENTY_FOUR(24), TWENTY_FIVE(25),
        THIRTY_ONE31(31);
    }

    companion object {
        var starDayInventory = mutableListOf<Int>()
        fun weekendCheck(inputDate: Int): DayOfWeek {
            return LocalDate.of(2023, 12, inputDate).dayOfWeek
        }

        fun getAllStarDay(): MutableList<Int> {
            for (clue in StarEvent.values()) {
                starDayInventory.add(clue.dayNumber)
            }
            return starDayInventory
        }
    }
}