class Solution {
    fun arraySign(nums: IntArray): Int {
        return nums.fold(1) { a, b ->
            val product = a * b
            if(product == 0) 0
            else if(product < 0) -1
            else 1
        }
    }
}
