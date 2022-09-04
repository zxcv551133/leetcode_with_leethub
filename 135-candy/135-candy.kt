class Solution {
    fun candy(ratings: IntArray): Int {
        val ratingsTail = ratings.drop(1)
        val left = ratings.zip(ratingsTail).fold(listOf(1)) { acc, (first, second) ->
            if (second > first) {
                acc + (acc.last() + 1)
            } else {
                acc + 1
            }
        }
        val right = ratings.zip(ratingsTail).foldRight(listOf(1)) { (first, second), acc ->
            if (first > second) {
                acc + (acc.last() + 1)
            } else {
                acc + 1
            }
        }.reversed()
        return left.zip(right).map { kotlin.math.max(it.first, it.second) }.sum()
    }
}