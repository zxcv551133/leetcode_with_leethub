class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    fun checkValidString(s: String): Boolean {
        stringCandidate = s
        return dp(Pair(0, s.length - 1))
    }

    lateinit var stringCandidate: String
    val setParenthesis = listOf("()", "(*", "*)", "**").toSet()
    val dp: (Pair<Int, Int>) -> Boolean by Memoize { (i, j) ->
        if (i == j) {
            stringCandidate[i] == '*'
        } else if (i + 1 == j) {
            setParenthesis.contains(stringCandidate[i].toString() + stringCandidate[j].toString())
        } else {
            val cons = stringCandidate[i].toString() + stringCandidate[j].toString()
            val step = if (setParenthesis.contains(cons)) dp(Pair(i + 1, j - 1)) else false
            (i until j).map {
                dp(Pair(i, it)) && dp(Pair(it + 1, j))
            }.reduce { acc, current -> acc || current } || step
        }
    }
}