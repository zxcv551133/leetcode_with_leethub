class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }

    fun countBits(n: Int): IntArray {
        return (0..n).map(popCount).toIntArray()
    }

    val popCount: (Int) -> Int by Memoize { num ->
        if (num == 0) {
            0
        } else {
            num % 2 + popCount(num shr 1)
        }
    }
}