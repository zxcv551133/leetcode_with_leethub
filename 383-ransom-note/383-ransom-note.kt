class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean = IntArray(26).apply {
        magazine.forEach { c -> this[c - 'a']++ }
        ransomNote.forEach { c ->
            if (--this[c - 'a'] < 0) return false
        }
    }.let { true }
}