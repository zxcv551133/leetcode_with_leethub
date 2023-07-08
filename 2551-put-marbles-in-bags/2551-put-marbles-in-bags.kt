class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val pairs = weights.zip(weights.drop(1))
        val sorted = pairs.map { (it.first + it.second).toLong() }.sorted()
        val minList = sorted.subList(0, k - 1)
        val maxList = sorted.subList(weights.size - k, weights.size - 1)
        
        val firstLastSum = weights.first() + weights.last()
        
        val minVal = minList.sum() + firstLastSum
        val maxVal = maxList.sum() + firstLastSum
        
        return maxVal - minVal
    }
}
