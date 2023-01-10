class Solution {
    fun reorganizeString(s: String): String {
        val maxSize = s.groupBy { it }.map { it.value.size }.max()!!
        if (s.length - maxSize < maxSize - 1) return ""
        val ar = Array(maxSize) { StringBuilder() }

        for (c in s.groupBy { it }.map { it.value }.sortedBy { it.size }.reversed().flatten().withIndex()) {
            ar[c.index % maxSize].append(c.value)
        }
        return ar.reduce { acc, current -> acc.append(current) }.toString()
    }
}