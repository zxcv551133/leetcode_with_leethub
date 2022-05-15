class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }

    val memoizedUniquePaths: (Pair<Int, Int>) -> Int by Memoize { coordinate: Pair<Int, Int> ->
        val (m, n) = coordinate
        if (m == 1 || n == 1) {
            1
        } else {
            memoizedUniquePaths(Pair(m - 1, n)) + memoizedUniquePaths(Pair(m, n - 1))
        }
    }

    fun uniquePaths(m: Int, n: Int): Int {
        return memoizedUniquePaths(Pair(m, n))
    }
}