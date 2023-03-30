class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        val dp = Array(s1.length + 1) { Array(s1.length) { BooleanArray(s1.length) { false } } }
        for (i in s1.indices) {
            for (j in s2.indices) {
                if(s1[i] == s2[j]) dp[1][i][j] = true
                // println("$i $j 1 ${dp[1][i][j]}")
            } 
        }

        for (len in 2..s1.length) {
            for (i in s1.indices) {
                for(j in s2.indices) {
                    if(i + len > s1.length || j + len > s2.length) continue
                    for(subLen in 1 until len) {
                        if((dp[subLen][i][j + len - subLen] && dp[len - subLen][i + subLen][j]) ||
                            (dp[subLen][i][j] && dp[len - subLen][i + subLen][j + subLen])
                        ) {
                            dp[len][i][j] = true
                            continue
                        }
                        // println("$i $j $len $subLen ${dp[len][i][j]}")
                    }
                    // println("$i $j $len ${dp[len][i][j]}")
                }
            }
        }

        return dp[s1.length][0][0]
    }
}
