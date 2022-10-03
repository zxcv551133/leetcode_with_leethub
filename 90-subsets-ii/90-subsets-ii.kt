class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        return (1..(1 shl nums.size)).map { currentP ->
            nums.indices.flatMap {
                if (currentP.and(1 shl it) > 0) {
                    listOf(nums[it])
                } else {
                    listOf()
                }
            }.sorted()
        }.toSet().toList()
    }
}