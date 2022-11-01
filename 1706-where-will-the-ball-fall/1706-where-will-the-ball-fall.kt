class Solution {
    fun findBall(A: Array<IntArray>): IntArray {
        var M = A.size
        var N = A[0].size
        fun drop(i: Int, j: Int): Int {
            return if (i == M) j else if (j in 0..N - 1 && j + A[i][j] in 0..N - 1 && A[i][j] == A[i][j + A[i][j]]) drop(i + 1, j + A[i][j]) else -1
        }
        return IntArray(N) { drop(0, it) }
    }
}