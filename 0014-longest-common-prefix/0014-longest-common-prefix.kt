class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        return strs.reduce { acc, s -> getCommonPrefix(acc, s) }
    }

    private fun getCommonPrefix(a: String, b: String): String {
        if (a.isEmpty() || b.isEmpty()) return ""
        if (a.length > b.length) {
            return getCommonPrefix(b, a)
        }
        val ret = java.lang.StringBuilder("")
        for (i in a.indices) {
            if (a[i] == b[i]) ret.append(a[i])
            else break
        }
        return ret.toString()
    }
}