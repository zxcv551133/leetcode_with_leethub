class Solution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var hi = 100000000000000
        var lo = 0L
        while(lo + 1 < hi) {
            val mi = (lo + hi) / 2
            if(isMinimumTimeAvailable(time, mi, totalTrips)) {
                hi = mi
            } else {
                lo = mi
            }
        }
        return hi
    }
    
    fun isMinimumTimeAvailable(time: IntArray, currentTime: Long, totalTrips: Int): Boolean {
        return time.map { currentTime / it }.sum() >= totalTrips
    }
}