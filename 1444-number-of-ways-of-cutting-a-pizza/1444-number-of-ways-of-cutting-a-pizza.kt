class Solution {
    fun ways(pizza: Array<String>, k: Int): Int {
        val mod = 1000000007
        val getRangeSum = Array(pizza.size + 1) { IntArray(pizza[0].length + 1) }
        for (i in pizza.indices) {
            for (j in pizza[0].indices) {
                getRangeSum[i + 1][j + 1] =
                    getRangeSum[i + 1][j] +
                            getRangeSum[i][j + 1] -
                            getRangeSum[i][j] +
                            if (pizza[i][j] == 'A') 1 else 0
            }
        }

        val dp = Array(pizza.size + 1) {
            Array(pizza[0].length + 1) {
                IntArray(k + 1)
            }
        }

        fun getCurrentSum(i: Int, j: Int): Int {
            return getRangeSum[pizza.size][pizza[0].length] -
                    getRangeSum[i][pizza[0].length] -
                    getRangeSum[pizza.size][j] +
                    getRangeSum[i][j]
        }
        
        // println(getCurrentSum(0,0))
        // println(getRangeSum[pizza.size][pizza[0].length])

        for (i in pizza.indices) {
            for (j in pizza[0].indices) {
                dp[i][j][0] = if(getCurrentSum(i, j) == 0) 0 else 1
            }
        }

        for (cut in 1 until k) {
            for (i in pizza.indices) {
                for (j in pizza[0].indices) {
                    for (vert in i + 1 until pizza.size)  {
                        val currentSum = getCurrentSum(i, j)
                        val cutSum = getCurrentSum(vert, j)
                        if(currentSum > cutSum) {
                            dp[i][j][cut] += dp[vert][j][cut - 1]
                        }
                        // println("$i $j $vert $j $cut $currentSum $cutSum")
                        dp[i][j][cut] %= mod
                    }
                    for (hori in j + 1 until pizza[0].length) {
                        val currentSum = getCurrentSum(i, j)
                        val cutSum = getCurrentSum(i, hori)
                        if(currentSum > cutSum) {
                            dp[i][j][cut] += dp[i][hori][cut - 1]
                        }
                        // println("$i $j $i $hori $cut $currentSum $cutSum")
                        dp[i][j][cut] %= mod
                    }
                }
            }
        }
        
        return dp[0][0][k - 1]
    }
}