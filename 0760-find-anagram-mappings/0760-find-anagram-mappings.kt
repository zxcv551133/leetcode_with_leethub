class Solution {
    fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
        val numMap = nums2.mapIndexed { idx, num -> Pair(num, idx) }
            .groupBy { it.first }
            .mapValues { (_, li) -> li.map{it.second}.toMutableSet() }

        val ret = IntArray(nums1.size)

        for (i in ret.indices) {
            ret[i] = numMap[nums1[i]]!!.first()
            numMap[nums1[i]]!!.drop(1)
        }

        return ret
    }
}