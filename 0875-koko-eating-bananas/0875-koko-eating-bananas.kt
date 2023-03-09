class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var hi = 100000000000000
        var lo = 0L
        while(lo + 1 < hi) {
            val mi = (lo + hi) / 2
            if(canEatAll(piles, h, mi)) {
                hi = mi
            } else {
                lo = mi
            }
        }
        return hi.toInt()
    }

    private fun canEatAll(piles: IntArray, h: Int, k: Long): Boolean {
        return piles.map { (it + k - 1) / k }.sum() <= h
    }
}