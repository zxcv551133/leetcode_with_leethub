class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    fun generateParenthesis(n: Int): List<String> {
        return makeParenthesis(n)
    }

    val makeParenthesis: (Int) -> List<String> by Memoize { n ->
        when (n) {
            0 -> listOf("")
            1 -> listOf("()")
            else -> {
                (0 until n).flatMap { idx ->
                    val rightStrList = generateParenthesis(n - idx - 1)
                    val leftStrList = generateParenthesis(idx).map { "($it)" }
                    leftStrList.flatMap { leftStr -> rightStrList.map { leftStr + it } }
                }
            }
        }
    }
}