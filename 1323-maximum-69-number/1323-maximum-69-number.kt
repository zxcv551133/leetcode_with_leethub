class Solution {
    fun maximum69Number(num: Int): Int {
        val numString = num.toString()
        return numString.replaceFirst('6', '9').toInt()
    }
}