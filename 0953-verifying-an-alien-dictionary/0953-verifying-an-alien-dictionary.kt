class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val orderMap = order.mapIndexed { idx, c -> Pair(c, 'a' + idx)}.toMap()
        val converted = words.map { word -> word.map { c -> orderMap[c] }.joinToString("") }
        val sorted = converted.sorted()

        return converted == sorted
    }
}