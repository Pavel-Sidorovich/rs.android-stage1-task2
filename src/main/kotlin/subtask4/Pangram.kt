package subtask4

import java.util.regex.Pattern

class Pangram {

    private val vowels = arrayOf(
        'a', 'e', 'i', 'o', 'u', 'y',
        'A', 'E', 'I', 'O', 'U', 'Y'
    )
    private val consonants = arrayOf(
        'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z',
        'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'
    )

    fun getResult(inputString: String): String {
        return if (isPangram(inputString)) {
            function(inputString, vowels)
        } else {
            function(inputString, consonants)
        }
    }

    private fun function(inputString: String, arrayChar: Array<Char>): String {
        val list = inputString.trim().split(Pattern.compile("[ \n]+")).toMutableList()
        var i = 0
        while (i < list.size) {
            var count = 0
            val array = list[i].toCharArray()
            array.indices.forEach {
                if (arrayChar.contains(array[it])) {
                    array[it] = array[it].toUpperCase()
                    count++
                }
            }
            if (array.isNotEmpty()) {
                list[i] = "$count${String(array)}"
            }
            i++
        }
        val buffer = StringBuffer()
        list.sortedBy { it[0] }.forEach { buffer.append("$it ") }
        return buffer.toString().trim()
    }

    private fun isPangram(inputString: String): Boolean {
        val listChars = "abcdefghijklmnopqrstuvwxyz".toCharArray().asList().toMutableList()

        val list = inputString.toLowerCase().toCharArray().asList().toMutableList()
        list.sort()

        for (i in listChars) {
            if (!list.contains(i)) {
                return false
            }
        }

        return true
    }
}
