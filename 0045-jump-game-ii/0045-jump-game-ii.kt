class Solution {
        class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }


    private lateinit var nums: IntArray;

    val memoizedJump: (Int) -> Int by Memoize { idx: Int ->
        if (idx >= nums.size - 1) {
            0
        } else if (nums[idx] == 0) {
            nums.size
        } else {
            (1..minOf(nums[idx], nums.size - idx - 1))
                .map {
                    memoizedJump(it + idx)
                }
                .minBy {
                    it
                }!! + 1
        }
    }
    
    fun jump(nums: IntArray): Int {
        this.nums = nums

        return memoizedJump(0)
    }
}