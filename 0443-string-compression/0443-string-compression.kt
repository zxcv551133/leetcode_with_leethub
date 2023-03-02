class Solution {
    fun compress(chars: CharArray): Int {
        val (list, current, currentCount) = chars.fold(Triple(LinkedList<Pair<Char, Int>>(), '.', 0)) { (acc, previousChar, previousCount), currentChar ->
            if(previousChar == currentChar) {
                Triple(acc, previousChar, previousCount + 1)
            } else {
                val previousPair = Pair(previousChar, previousCount)
                acc.addLast(previousPair)
                Triple(acc, currentChar, 1)
            }
        }
        list.addLast(Pair(current, currentCount))
        val ret = list.drop(1).map { (c, count) ->
            if (count == 1) "$c" else "$c$count"
        }.joinToString("")

        chars.dropLast(chars.size - ret.length)
        for(i in ret.indices) {
            chars[i] = ret[i]
        }

        return ret.length
    }
}