class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        arr.toSet()
        val remain = ((1..2000).toSet() - arr.toSet()).toIntArray()
        remain.sort()
        return remain[k - 1]
    }
}