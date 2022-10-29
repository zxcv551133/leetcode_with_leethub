class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ret = strs.groupBy { it.groupBy { it } }.values.toList()
        return ret
    }
}