class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        return arr.sortedWith(compareBy<Int> { kotlin.math.abs(it - x) }.thenBy { it })
            .subList(0, k)
            .sorted()
    }
}