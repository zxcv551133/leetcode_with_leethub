class Solution {
    fun addDigits(num: Int): Int {
        return if(num == 0) 0 else 1 + (num - 1) % 9
    }
}
