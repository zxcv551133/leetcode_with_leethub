class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }

    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        if (jobDifficulty.size < d) {
            return -1
        }
        this.jobDifficulty = jobDifficulty
        return minimumSplit(Pair(jobDifficulty.size - 1, d))
    }
    val getMaxValue: (Pair<Int, Int>) -> Int by Memoize { (start, end) ->
        if (start == end) {
            jobDifficulty[start]
        } else {
            maxOf(getMaxValue(Pair(start, end - 1)), jobDifficulty[end])
        }
    }

    lateinit var jobDifficulty: IntArray

    val minimumSplit: (Pair<Int, Int>) -> Int by Memoize { (days, split) ->
        if (days + 1 < split || days < 0) {
            Int.MAX_VALUE / 2
        } else if (split == 1) {
            getMaxValue(Pair(0, days))
        } else {
            var ret = Int.MAX_VALUE

            for (i in 0 until days) {
                val current = minimumSplit(Pair(i, split - 1)) + getMaxValue(Pair(i + 1, days))
                ret = minOf(current, ret)
            }
            ret
        }
    }
}