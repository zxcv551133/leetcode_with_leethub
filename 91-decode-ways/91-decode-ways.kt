class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    lateinit var charSet: Set<String>
    lateinit var currentString: String
    fun numDecodings(s: String): Int {
        currentString = s
        charSet = (1..26).map { it.toString() }.toSet()
        (s.indices).map(mappingWays)
        return mappingWays(s.length - 1)
    }

    val mappingWays: (Int) -> Int by Memoize { idx ->
        when (idx) {
            0 -> if (charSet.contains(currentString.substring(idx, idx + 1))) 1 else 0
            1 -> {
                val twoChar = if (charSet.contains(currentString.substring(idx - 1, idx + 1))) 1 else 0
                val oneChar = if (charSet.contains(currentString.substring(idx, idx + 1))) 1 else 0
                oneChar * mappingWays(idx - 1) + twoChar
            }
            else -> {
                val twoChar = if (charSet.contains(currentString.substring(idx - 1, idx + 1))) 1 else 0
                val oneChar = if (charSet.contains(currentString.substring(idx, idx + 1))) 1 else 0
                oneChar * mappingWays(idx - 1) + twoChar * mappingWays(idx - 2)
            }
        }
    }
}