class Solution {
    fun shortestWay(source: String, target: String): Int {
        val charToIndices = mutableMapOf<Char, MutableList<Int>>()
        for ((i, c) in source.withIndex()) {
            if (!charToIndices.containsKey(c)) {
                charToIndices[c] = mutableListOf()
            }
            charToIndices[c]!!.add(i)
        }

        var sourceIterator = 0

        var count = 1

        for (c in target) {
            if (!charToIndices.containsKey(c)) {
                return -1
            }

            val indices = charToIndices[c]!!
            val index = binarySearch(indices, sourceIterator)

            if (index == indices.size) {
                count += 1
                sourceIterator = indices[0] + 1
            } else {
                sourceIterator = indices[index] + 1
            }
        }

        return count
    }

    fun binarySearch(arr: List<Int>, target: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (arr[mid] == target) {
                return mid
            } else if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }
}
