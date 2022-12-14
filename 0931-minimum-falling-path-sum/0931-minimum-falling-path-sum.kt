class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }
    
    lateinit var matrix: Array<IntArray>

    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        this.matrix = matrix
        return matrix.indices.map { minFallingSum(Pair(matrix.size - 1, it)) }.min()!!
    }

    val minFallingSum: (Pair<Int, Int>) -> Int by Memoize { (row, col) ->
        if (col < 0 || col >= matrix[0].size) 10000
        else if (row == 0) matrix[row][col]
        else {
            listOf(Pair(row - 1, col - 1), Pair(row - 1, col), Pair(row - 1, col + 1))
                .map(minFallingSum)
                .min()!! + matrix[row][col]
        }
    }
}