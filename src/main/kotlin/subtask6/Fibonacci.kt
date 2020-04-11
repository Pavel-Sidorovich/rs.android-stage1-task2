package subtask6

class Fibonacci {
    private val list = mutableListOf<Int>()

    fun productFibonacciSequenceFor(n: Int): IntArray {
        list.add(0, 0)
        list.add(1, 1)

        var i = -1
        var temp: Int

        do {
            i++
            temp = fib(i) * fib(i + 1)
        } while (temp < n)

        return if (temp == n) {
            intArrayOf(list[i], list[i + 1], 1)
        } else {
            intArrayOf(list[i], list[i + 1], 0)
        }
    }

    private fun fib(n: Int): Int {
        return if (list.size > n) {
            list[n]
        } else {
            list.add(n,fib(n - 1) + fib(n - 2))
            list[n]
        }
    }
}
