class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    private val squareNums = (1..100).map { it * it }.toSet()
    fun numSquares(n: Int): Int {
        for (i in 1 until (n / 2) + 1) {
            getNumSquares(i)
        }
        return getNumSquares(n)
    }

    val getNumSquares: (Int) -> Int by Memoize { n ->
        if (squareNums.contains(n)) {
            1
        } else {
            (1..kotlin.math.sqrt((n / 2 + 1).toDouble()).toInt()).map {
                1 + getNumSquares(n - it * it)
            }.min()!!
        }
    }
}