class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var ret = 0
        for (i in mat.indices) {
            val left = Pair(i, i)
            val right = Pair(i, mat.size - i - 1)
            if(left == right) ret -= mat[left.first][left.second]
            ret += mat[left.first][left.second]
            ret += mat[right.first][right.second]
        }
        return ret
    }
}
