package subtask3

fun main() {
    print(Abbreviation().abbreviationFromA("daBcd", "ABC"))
}

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val from = a.toCharArray().toMutableList()
        val to = b.toCharArray().toMutableList()

        var count = 0

        for (cTo in to) {
            while (from.size != 0) {
                if (from[0] == cTo || from[0].toUpperCase() == cTo) {
                    count ++
                    break
                }
                from.removeAt(0)
            }
        }
        return if (count == to.size) {
            "YES"
        } else {
            "NO"
        }

    }
}
