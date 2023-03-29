class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        val sorted = satisfaction.sorted().reversed()
        return sorted.fold(Triple(0, 0, 0)) { (currentPreSum, currentMax, currentSum), num ->
            val newPreSum = currentPreSum + num
            val newSum = newPreSum + currentSum
            val newMax = kotlin.math.max(currentMax, newSum)
            Triple(newPreSum, newMax, newSum)
        }.second
    }
}
