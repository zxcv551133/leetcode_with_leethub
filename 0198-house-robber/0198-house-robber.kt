class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    lateinit var nums: IntArray
    fun rob(nums: IntArray): Int {
        this.nums = nums
        return nums.indices.map(robMaximum).max()!!
    }

    val robMaximum: (Int) -> Int by Memoize { idx ->
        if (idx < 0) 0
        else if (idx <= 1) nums[idx]
        else {
            maxOf(robMaximum(idx - 2), robMaximum(idx - 3)) + nums[idx]
        }
    }
}