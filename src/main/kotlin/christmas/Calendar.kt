package christmas

import java.time.DayOfWeek
import java.time.LocalDate


class Calendar {

    companion object {
        fun weekendCheck(): DayOfWeek {
            return LocalDate.of(2023, 12, Input.orderDate).dayOfWeek
        }
    }
}