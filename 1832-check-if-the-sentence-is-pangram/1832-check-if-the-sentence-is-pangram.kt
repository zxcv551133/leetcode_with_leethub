class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        return sentence.groupBy { it }.size == 26
    }
}