class Solution {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        return map.entries.sortedByDescending { it.value }.take(k).map { it.key }
    }
}
