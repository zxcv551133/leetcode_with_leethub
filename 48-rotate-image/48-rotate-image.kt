class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (i: Int in 0..matrix.size / 2) {
            for (j: Int in i until matrix.size - i - 1) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[matrix.size - 1 - j][i]
                matrix[matrix.size - 1 - j][i] = matrix[matrix.size - 1 - i][matrix.size - 1 - j]
                matrix[matrix.size - 1 - i][matrix.size - 1 - j] = matrix[j][matrix.size - 1 - i]
                matrix[j][matrix.size - 1 - i] = temp
            }
        }
    }
}