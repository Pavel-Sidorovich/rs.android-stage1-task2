package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("ru"))
            sdf.isLenient = false
            val myDate = sdf.parse("$day/$month/$year")
            val calendar = Calendar.getInstance()
            calendar.time = myDate

            val dayOfWeek = when (calendar.get(Calendar.DAY_OF_WEEK)) {
                1 -> "воскресенье"
                2 -> "понедельник"
                3 -> "вторник"
                4 -> "среда"
                5 -> "четверг"
                6 -> "пятница"
                7 -> "суббота"
                else -> "Такого дня не существует"
            }
            val textMonth = when (month) {
                "1" -> "января"
                "2" -> "февраля"
                "3" -> "марта"
                "4" -> "апреля"
                "5" -> "мая"
                "6" -> "июня"
                "7" -> "июля"
                "8" -> "августа"
                "9" -> "сентября"
                "10" -> "октября"
                "11" -> "ноября"
                "12" -> "декабря"
                else -> "Такого дня не существует"
            }
            return "$day $textMonth, $dayOfWeek"
        } catch (e: Exception) {
            return "Такого дня не существует"
        }

    }
}
