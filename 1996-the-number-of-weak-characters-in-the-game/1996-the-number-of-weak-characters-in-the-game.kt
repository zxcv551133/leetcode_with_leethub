class Solution {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        val attckSorted = properties.map { Pair(it[0], it[1]) }.sortedBy { it.first }.reversed()
        val defenseSortedQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        defenseSortedQueue.addAll(attckSorted)

        return attckSorted
            .fold(Pair(0, defenseSortedQueue)) { (ans, defense), attack ->
                var count = 0
                while (defense.peek().second < attack.second) {
                    if (defense.poll().first < attack.first) count += 1
                }
                Pair(ans + count, defense)
            }.first
    }
}