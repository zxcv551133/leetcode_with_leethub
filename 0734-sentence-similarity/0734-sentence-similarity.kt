class Solution {
    fun areSentencesSimilar(sentence1: Array<String>, sentence2: Array<String>, similarPairs: List<List<String>>): Boolean {
        if (sentence1.size != sentence2.size) return false

        val pairMap =
            similarPairs
                .flatMap { listOf(Pair(it[0], it[1]), Pair(it[1], it[0])) }
                .groupBy { it.first }
                .mapValues { (k, v) -> v.map { it.second }.toSet() + k }

       return sentence1.zip(sentence2).all { pairMap.getOrDefault(it.first, setOf(it.first)).contains(it.second) }
    }
}