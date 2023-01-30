class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    fun tribonacci(n: Int): Int {
        return tribonacciVal(n)
    }

    val tribonacciVal: (Int) -> Int by Memoize { n ->
        when(n) {
            0 -> 0
            1 -> 1
            2 -> 1
            else -> tribonacciVal(n - 1) + tribonacciVal(n - 2) + tribonacciVal(n - 3)
        }
    }
}