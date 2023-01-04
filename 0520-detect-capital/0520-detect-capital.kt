class Solution {
    fun detectCapitalUse(word: String): Boolean {
        return word.all { it.isUpperCase() }
                || word.all { it.isLowerCase() }
                || word.takeLastWhile { it.isLowerCase() } == word.drop(1)
    }
}