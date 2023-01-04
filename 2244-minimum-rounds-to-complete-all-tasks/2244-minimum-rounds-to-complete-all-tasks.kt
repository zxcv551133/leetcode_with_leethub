class Solution {
    fun minimumRounds(tasks: IntArray): Int {
        val eachCount = tasks.groupBy { it }.mapValues { (_, v) -> v.size }
        val rounds = eachCount.values.map { size ->
            if(size == 1) -1
            else (size + 2)/ 3
        }
        return if (rounds.any { it == -1 }) {
            -1
        } else {
            rounds.sum()
        }
    }
}