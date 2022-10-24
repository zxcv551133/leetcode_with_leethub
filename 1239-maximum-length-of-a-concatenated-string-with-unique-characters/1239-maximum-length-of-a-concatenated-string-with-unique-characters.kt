class Solution {
    fun maxLength(arr: List<String>): Int {
        val setArr = arr.filter { it.length == it.toSet().size }.map { it.toSet() }.toTypedArray()
        var maxLen = 0
        for (i in 0 .. (1 shl setArr.size)) {
            var currentSet = setOf<Char>()
            for(j in 0 until setArr.size) {
                if(((1 shl j) and i) == 0) {
                    continue
                }
                if(currentSet.intersect(setArr[j]).isNotEmpty()) {
                    break
                }
                currentSet = currentSet + setArr[j]
            }
            maxLen = maxOf(maxLen, currentSet.size)
        }

        return maxLen
    }
}