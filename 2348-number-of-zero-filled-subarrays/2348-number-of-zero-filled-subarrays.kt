class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        val arrayList = mutableListOf<Long>()
        var cnt = 0L
        for(i in nums.indices) {
            if(nums[i] == 0) {
                cnt++
            } else {
                arrayList.add(cnt)
                cnt = 0
            }
        }
        arrayList.add(cnt)
        return arrayList
            .filterNot { it == 0L }
            .groupBy { it }
            .mapValues { (_, v) -> v.size }
            .map { (k, v) -> (k + 1) * k / 2 * v }
            .sum()
    }
}
