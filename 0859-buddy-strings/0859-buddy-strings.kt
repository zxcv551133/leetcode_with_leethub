class Solution {
    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length == 1) return false
        if (s.length != goal.length) return false
        if (s == goal && s.groupBy { it }.any { it.value.size > 1 }) return true
        val diff = mutableListOf<Int>()
        for (i in s.indices) {
            if (s[i] != goal[i]) diff.add(i)
        }
        if (diff.size != 2) return false

        return s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]]
    }
}
