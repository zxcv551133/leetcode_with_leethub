class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        val dp = Array(s1.length) { Array(s1.length) { BooleanArray(s1.length + 1) { false } } }
        for (i in s1.indices) {
            for (j in s2.indices) {
                if(s1[i] == s2[j]) dp[i][j][1] = true
            }
        }

        for (len in 2..s1.length) {
            for (i in s1.indices) {
                for(j in s2.indices) {
                    if(i + len > s1.length || j + len > s2.length) continue
                    for(subLen in 1 until len) {
                        if((dp[i][j + len - subLen][subLen] && dp[i + subLen][j][len - subLen]) ||
                            (dp[i][j][subLen] && dp[i + subLen][j + subLen][len - subLen])
                        ) {
                            dp[i][j][len] = true
                            continue
                        }
                    }
                }
            }
        }

        return dp[0][0][s1.length]
    }
}
