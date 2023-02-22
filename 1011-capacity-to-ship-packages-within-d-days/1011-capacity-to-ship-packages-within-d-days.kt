class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var hi = 500 * 50000
        var lo = 0
        while(lo + 1 < hi) {
            val mi = (lo + hi) / 2
            println("$lo $hi $mi")
            if(isAvailable(weights = weights, capacity = mi, days= days)) {
                hi = mi
            } else {
                lo = mi
            }
            println("done $lo $hi $mi")
        }
        return hi
    }

    private fun isAvailable(weights: IntArray, capacity: Int, days: Int): Boolean {
        if(weights.any { capacity < it}) {
            return false
        }

        return weights.fold(Pair(1, capacity)) { (currentDay, remainCap), weight ->
            if(remainCap < weight) {
                Pair(currentDay + 1, capacity - weight)
            } else {
                Pair(currentDay, remainCap - weight)
            }
        }.first <= days
    }
}