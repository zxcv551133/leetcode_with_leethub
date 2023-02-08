class Solution {
    fun wiggleSort(nums: IntArray): Unit {
        for((index, num) in nums.withIndex()) {
            if((index % 2 == 1 && num < nums[index - 1])
                || (index > 0 && index % 2 == 0 && num > nums[index - 1])) {
                nums[index] = nums[index - 1]
                nums[index - 1] = num
            }
        }
    }
}