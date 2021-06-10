package subtask1

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeParseException
import java.util.*


class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val dateFormat = SimpleDateFormat("d MMMM, EEEE", Locale("ru"))
        val date = GregorianCalendar ()
        date.isLenient = false         // False
        date.set(year.toInt(), month.toInt() - 1, day.toInt())
        return try {
            date.time
            dateFormat.format(date.time) // true = Valid data entered for a date.
        } catch (e: IllegalArgumentException) {
            "Такого дня не существует" // Exception caught, meaning invalid data-entry.
        }
    }
}
