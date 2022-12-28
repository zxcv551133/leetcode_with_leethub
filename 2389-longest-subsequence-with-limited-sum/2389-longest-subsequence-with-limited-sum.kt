import java.util.TreeMap

class Solution {
    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        nums.sort()
        val currentMap = TreeMap<Int, Int>()
        currentMap[nums[0]] = 1
        for (i in 1 until nums.size) {
            currentMap[currentMap.lastKey() + nums[i]] = i + 1
        }
        return queries.map { q ->
            val floorEntry = currentMap.floorEntry(q)
            if (floorEntry == null) 0
            else floorEntry.value
        }.toIntArray()
    }
}