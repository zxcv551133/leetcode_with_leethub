class Solution {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        val mutableList = mutableListOf<List<Int>>()

        (nums + (upper + 1)).fold(lower) { acc, num ->
            if(acc <= num - 1) {
                mutableList.add(mutableListOf(acc, num - 1))
            }
            num + 1
        }

        return mutableList
    }
}
