class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    private val mod = 1000000007
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        return numsRoll(Triple(target, n, k)).toInt()
    }

    val numsRoll: (Triple<Int, Int, Int>) -> Long by Memoize { (targetVal, num, diceFace) ->
        if (num == 0) {
            if (targetVal == 0) 1 else 0
        } else if (targetVal <= 0) {
            0
        } else {
            (1..diceFace).map {
                numsRoll(Triple(targetVal - it, num - 1, diceFace)) % mod
            }.sum() % mod
        }
    }
}