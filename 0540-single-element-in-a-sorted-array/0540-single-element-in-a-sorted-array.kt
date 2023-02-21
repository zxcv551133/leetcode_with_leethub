class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var cnt = 0
        var before = 0
        for(n in nums) {
            if(before != n) {
                if(cnt == 1) {
                    return before
                }
                before = n
                cnt = 0
            }
            cnt++
        }
        if(cnt == 1) return before
        
        return -1
    }
}