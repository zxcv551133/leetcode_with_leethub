class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }

    fun combinationSum4(nums: IntArray, target: Int): Int {
        this.numsSet = nums.toSet()
        return combinationSum(Pair(target, 1000))
    }

    private lateinit var numsSet: Set<Int>

    val combinationSum: (Pair<Int, Int>) -> Int by Memoize { (target, length) ->
        if (target < 0) {
            0
        } else if (target == 0) {
            1
        } else if (length == 1) {
            if (numsSet.contains(target)) {
                1
            } else {
                0
            }
        } else {
            var count = 0
            for (x in numsSet) {
                count += combinationSum(Pair(target - x, length - 1))
            }
            count
        }
    }
}