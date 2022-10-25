class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val word1Concat = word1.fold(StringBuilder()) { acc, str -> acc.append(str) }.toString()
        val word2Concat = word2.fold(StringBuilder()) { acc, str -> acc.append(str) }.toString()
        return word1Concat == word2Concat
    }
}