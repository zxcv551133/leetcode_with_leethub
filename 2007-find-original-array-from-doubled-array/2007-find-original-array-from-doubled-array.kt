import java.util.TreeMap

class Solution {
    fun findOriginalArray(changed: IntArray): IntArray {
        changed.sort()
        val currentMap = changed.groupBy { it }.mapValues { (_, v) -> v.size }
        val treeMap = TreeMap<Int, Int>()
        currentMap.forEach { (k, v) ->
            treeMap[k] = v
        }
        val acc = mutableListOf<Int>()

        return if (loopWithMap(treeMap, treeMap.iterator(), acc)) acc.toIntArray() else intArrayOf()
    }

    private fun loopWithMap(
        mutableMap: TreeMap<Int, Int>,
        currentIterator: MutableIterator<MutableMap.MutableEntry<Int, Int>>,
        acc: MutableList<Int>
    ): Boolean {
        if (!currentIterator.hasNext()) {
            return true
        }
        val current = currentIterator.next()
        if (current.value == 0) {
            return loopWithMap(mutableMap, currentIterator, acc)
        } else if ((mutableMap[current.key * 2] ?: 0) < current.value) {
            return false
        }
        if (current.key == 0) {
            return if (current.value % 2 != 0) {
                false
            } else {
                (1..current.value / 2).forEach { _ -> acc.add(current.key) }
                loopWithMap(mutableMap, currentIterator, acc)
            }
        }

        mutableMap[current.key * 2] = mutableMap[current.key * 2]!! - current.value
        (1..current.value).forEach { _ -> acc.add(current.key) }
        return loopWithMap(mutableMap, currentIterator, acc)
    }
}