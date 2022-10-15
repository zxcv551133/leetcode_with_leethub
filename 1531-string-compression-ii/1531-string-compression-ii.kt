class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }

    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        str = s
        return shortestLength(Pair(s.length - 1, k))
    }

    lateinit var str: String

    data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val forth: D)

    val shortestLength: (Pair<Int, Int>) -> Int by Memoize { (strIdx, deleteNum) ->
        if (strIdx < 0) {
            0
        } else {
            val whenDelete = if (deleteNum > 0) shortestLength(Pair(strIdx - 1, deleteNum - 1)) else Int.MAX_VALUE

            val initQuadruple = Quadruple(0, 0, Int.MAX_VALUE, false)
            val ret = (strIdx downTo 0).fold(initQuadruple) { (deleted, sameLength, currentMin, isDone), idx ->
                if (isDone || str[idx] != str[strIdx] && deleted == deleteNum) {
                    Quadruple(deleted, sameLength, currentMin, true)
                } else {
                    val (newLength, newDeleted) = if (str[idx] == str[strIdx]) {
                        Pair(sameLength + 1, deleted)
                    } else {
                        Pair(sameLength, deleted + 1)
                    }
                    val numSize = if (newLength <= 1) 0 else newLength.toString().length
                    val newMin = minOf(currentMin, shortestLength(Pair(idx - 1, deleteNum - newDeleted)) + 1 + numSize)
                    Quadruple(newDeleted, newLength, newMin, false)
                }
            }.third

            minOf(ret, whenDelete)
        }
    }
}