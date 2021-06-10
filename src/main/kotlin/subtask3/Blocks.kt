package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass


class Blocks  {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val str: KClass<*> = String::class
        val int: KClass<*> = Int::class
        val date: KClass<*> = LocalDate::class

        if (blockB.java === str.java) {
            var result = ""
            blockA.filterIsInstance<String>().forEach { result += it }
            return result
        }

        if (blockB.java === int.java) {
            var result = 0
            blockA.filterIsInstance<Int>().forEach { result += it }
            return result
        }

        if (blockB.java === date.java) {
            var result: LocalDate? = null

            blockA.filterIsInstance<LocalDate>().forEach {

                if (result == null && it.isBefore(LocalDate.now()))
                    result = it
                else if (result!!.isBefore(it) && it.isBefore(LocalDate.now())) result = it
            }
            val form = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale("ru"))
            return result?.format(form)!!
        }
        return ""
    }
}
