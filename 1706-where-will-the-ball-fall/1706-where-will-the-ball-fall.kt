class Solution {
        fun findBall(A: Array<IntArray>): IntArray {
            fun drop(i: Int, j: Int): Int {
                return if (i == A.size) {
                    j
                } else if (j in 0 until A[0].size && j + A[i][j] in 0 until A[0].size && A[i][j] == A[i][j + A[i][j]]) {
                    drop(
                        i + 1,
                        j + A[i][j]
                    )
                } else -1
            }
            return IntArray(A[0].size) { drop(0, it) }
        }
}