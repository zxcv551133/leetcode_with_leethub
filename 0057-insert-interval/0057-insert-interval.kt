class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val newRet = mutableListOf<IntArray>()
        var intervalSt = newInterval[0]
        var intervalEd = newInterval[1]
        for (interval in intervals) {
            if (interval[0] > newInterval[1] || interval[1] < newInterval[0]) {
                newRet.add(interval)
            } else {
                intervalSt = minOf(intervalSt, newInterval[0], interval[0])
                intervalEd = maxOf(intervalEd, newInterval[1], interval[1])
            }
        }
        newRet.add(intArrayOf(intervalSt, intervalEd))
        newRet.sortBy { it[0] }
        return newRet.toTypedArray()
    }
}