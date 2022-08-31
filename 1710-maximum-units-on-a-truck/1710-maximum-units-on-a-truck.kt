class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        val sortedBox = boxTypes.map { Pair(it[0], it[1]) }.sortedBy { -it.second }
        var maxUnits = 0
        var currentSize = 0
        sortedBox.forEach {
            for (i in 1..it.first) {
                if (currentSize >= truckSize) {
                    continue
                }
                maxUnits += it.second
                currentSize++
            }
        }

        return maxUnits
    }
}