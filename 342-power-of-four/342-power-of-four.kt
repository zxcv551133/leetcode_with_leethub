class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n == 1) {
            return true
        } else if (n == 0 || n % 4 != 0) {
            return false
        } else {
            return isPowerOfFour(n shr 2)
        }
    }
}