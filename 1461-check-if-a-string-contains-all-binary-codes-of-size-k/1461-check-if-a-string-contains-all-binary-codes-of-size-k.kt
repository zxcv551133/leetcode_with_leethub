class Solution {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val newS = s + "*".repeat(k)
        val set = s.indices.map {
            newS.substring(it, it + k)
        }.mapNotNull { it.toLongOrNull() }
            .map { it.toString() }
            .toSet()
        for (i in (0 until (1 shl k))) {
            if (!set.contains(Integer.toBinaryString(i))) return false
        }
        return true
    }
}