class Solution {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        val countMap = mutableMapOf<Char, Int>()
        var left = -1
        var longestSize = 0
        for (right in s.indices) {
            countMap[s[right]] = countMap.getOrDefault(s[right], 0) + 1
            while (countMap.size > k) {
                left++
                countMap[s[left]] = countMap[s[left]]!! - 1
                if (countMap[s[left]] == 0) countMap.remove(s[left])
            }
            longestSize = kotlin.math.max(right - left, longestSize)
        }
        return longestSize
    }
}
