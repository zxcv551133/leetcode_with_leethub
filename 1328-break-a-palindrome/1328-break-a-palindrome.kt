class Solution {
    fun breakPalindrome(palindrome: String): String {

        return (palindrome.indices).flatMap { idx ->
            val sb = java.lang.StringBuilder(palindrome)
            if (idx == palindrome.length / 2 && palindrome.length % 2 == 1) {
                listOf()
            } else {
                if (sb[idx] == 'a') {
                    sb[idx] = 'b'
                } else {
                    sb[idx] = 'a'
                }
                listOf(sb.toString())
            }
        }.min() ?: ""
    }
}