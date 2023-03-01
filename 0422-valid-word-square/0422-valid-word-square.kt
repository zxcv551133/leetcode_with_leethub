class Solution {
    fun validWordSquare(words: List<String>): Boolean {
        val maxLen = kotlin.math.max(words.map { it.length }.max()!!, words.size)
        val array = Array(maxLen){ Array(maxLen){'0'} }
        for ((i, word) in words.withIndex()) {
            for ((j, c) in word.withIndex()) {
                    array[i][j] = c
            }
        }
        for(i in array.indices) {
            for (j in array.indices) {
                if(array[i][j] != array[j][i]) return false
            }
        }
        return true
    }
}