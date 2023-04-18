class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        return buildString {
            (0 until kotlin.math.max(word1.length, word2.length)).forEach {
                append(word1.getOrNull(it) ?: "")
                append(word2.getOrNull(it) ?: "")
            }
        }
    }
}
