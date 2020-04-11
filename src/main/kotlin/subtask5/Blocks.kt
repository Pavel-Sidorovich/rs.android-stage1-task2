package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> {
                blockA.filterIsInstance<String>().reduce { acc, any -> acc + any }
            }
            Int::class -> {
                blockA.filterIsInstance<Int>().reduce { acc, any -> acc + any }
            }
            LocalDate::class -> {
                val date: LocalDate = blockA.filterIsInstance<LocalDate>().max() as LocalDate
                date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
            else -> {
            }
        }
    }
}
