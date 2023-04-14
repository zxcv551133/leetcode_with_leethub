class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length) { Array(2) { 0 } }
        var ret = 1
        for (i in s.indices) {
            dp[i][0] = 1

            var currentMaxLenOdd = 0
            var currentMaxLenEven = 0
            for (j in (0 until i).reversed()) {
                val prevMaxLenOdd = currentMaxLenOdd
                val prevMaxLenEven = currentMaxLenEven
                currentMaxLenOdd = kotlin.math.max(currentMaxLenOdd, dp[j][0])
                currentMaxLenEven = kotlin.math.max(currentMaxLenEven, dp[j][1])
                if(s[j] == s[i]) {
                    dp[j][0] = kotlin.math.max(prevMaxLenOdd + 2, dp[j][0])
                    dp[j][1] = kotlin.math.max(prevMaxLenEven + 2, dp[j][1])

                    ret = kotlin.math.max(ret, dp[j][0])
                    ret = kotlin.math.max(ret, dp[j][1])
                }
            }
        }

        return ret
    }
}
