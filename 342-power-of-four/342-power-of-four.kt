class Solution {
    fun isPowerOfFour(n: Int): Boolean {
       return if (n == 1) {
            true
        } else if (n == 0 || n % 4 != 0) {
            false
        } else {
            isPowerOfFour(n shr 2)
        }
    }
}