class Solution {
    fun frequencySort(s: String): String {
        return s.groupBy { it }.values.sortedBy { it.size }.reversed().flatten().joinToString(separator = "")
    }
}