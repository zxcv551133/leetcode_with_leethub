class Solution {
    fun countOdds(low: Int, high: Int): Int {
        return (high - low) / 2 + (high % 2 or low % 2)
    }
}