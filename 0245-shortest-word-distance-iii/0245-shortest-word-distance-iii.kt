class Solution {
    fun shortestWordDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
        val word1List = wordsDict
            .mapIndexed { idx, word -> Pair(idx, word) }
            .filter { it.second == word1 }
            .map { it.first }

        val word2List = wordsDict
            .mapIndexed { idx, word -> Pair(idx, word) }
            .filter { it.second == word2 }
            .map { it.first }

        val word1Set = TreeSet<Int>(word1List)
        
        var minDistance = Int.MAX_VALUE
        
        for (num in word2List) {
            val high = word1Set.higher(num)
            val low = word1Set.lower(num)
            if(high != null) minDistance = kotlin.math.min(minDistance, high - num)
            if(low != null) minDistance = kotlin.math.min(minDistance, num - low)
        }

        return minDistance
    }
}
