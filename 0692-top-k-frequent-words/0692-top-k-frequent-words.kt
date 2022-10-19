class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val wordsFrequency = words.groupBy { it }.mapValues { (_, value) -> value.size }
        val sortedFrequency =
            wordsFrequency.toList().sortedWith(compareBy<Pair<String, Int>> { -it.second }.thenBy { it.first })
        return sortedFrequency.take(k).map { it.first }
    }
}