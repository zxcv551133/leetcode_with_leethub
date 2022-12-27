class Solution {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        val currentCp = capacity.zip(rocks).map { (cp, rock) -> cp - rock }.sorted()
        var remainRocks = additionalRocks
        var ret = 0
        for (cp in currentCp) {
            if(cp > remainRocks) {
                break
            }
            remainRocks -= cp
            ret += 1
        }
        return ret
    }
}