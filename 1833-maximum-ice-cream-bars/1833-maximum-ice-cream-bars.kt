class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        var ret = 0
        var currentCoin = coins
        costs.sort()
        for (cost in costs) {
            if(cost > currentCoin) break
            currentCoin -= cost
            ret += 1
        }
        
        return ret
    }
}