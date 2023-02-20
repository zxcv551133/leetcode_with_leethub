class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().splitToSequence(" ").last().length
    }
}