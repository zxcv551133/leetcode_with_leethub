class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val strList = ArrayList<String>()
        if(nums.isEmpty()) return listOf()
        return nums.plus(nums[0]).drop(1).fold(Pair(strList, Pair(nums[0].toLong(), nums[0].toLong()))){ (li, p), num ->
            if(p.second + 1 == num.toLong()) {
                Pair(li, Pair(p.first, num.toLong()))
            } else {
                val toAddStr = if(p.first == p.second) {
                    "${p.first}"
                } else {
                    "${p.first}->${p.second}"
                }
                li.add(toAddStr)
                Pair(li, Pair(num.toLong(), num.toLong()))
            }
        }.first.toList()
    }
}
