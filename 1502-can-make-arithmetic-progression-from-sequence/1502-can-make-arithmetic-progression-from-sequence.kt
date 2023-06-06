class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val sorted = arr.sorted()
        val tailSorted = sorted.drop(1)
        println(sorted)
        println(tailSorted)
        val diff = tailSorted.first() - sorted.first()
        println(diff)
        return sorted.zip(tailSorted).all { (a, b) -> b - a == diff }
    }
}
