class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val sorted = arr.sorted()
        val tailSorted = sorted.drop(1)
        val diff = tailSorted.first() - sorted.first()
        return sorted.zip(tailSorted).all { (a, b) -> b - a == diff }
    }
}
