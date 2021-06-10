package subtask2

import java.lang.StringBuilder

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val string = StringBuilder(a.toUpperCase())
        val buffer = StringBuilder ( "")
        for (i in b.indices){
            if (string.contains(b[i])) {
                buffer.append(b[i])
                string.delete(0,string.indexOf(b[i]).inc())
            }
        }
        return if (buffer.toString() == b) "YES" else "NO"
    }
}
