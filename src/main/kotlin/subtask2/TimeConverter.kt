package subtask2

import java.lang.Exception

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val hourInt: Int
        val minuteInt: Int

        try {
            hourInt = hour.toInt()
            minuteInt = minute.toInt()
        } catch (e: Exception) {
            return "Это не числа"
        }
        val nums = arrayOf("zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine")

        return when (minuteInt) {
            0 -> "${nums[hourInt]} o' clock"
            1 -> "one minute past ${nums[hourInt]}"
            59 -> "one minute to ${nums[hourInt + 1]}"
            15 -> "quarter past ${nums[hourInt]}"
            30 -> "half past ${nums[hourInt]}"
            45 -> "quarter to ${nums[hourInt + 1]}"
            in 2..29 -> "${nums[minuteInt]} minutes past ${nums[hourInt]}"
            in 31..58 -> "${nums[60 - minuteInt]} minutes to ${nums[hourInt + 1]}"
            else -> ""
        }
    }
}
