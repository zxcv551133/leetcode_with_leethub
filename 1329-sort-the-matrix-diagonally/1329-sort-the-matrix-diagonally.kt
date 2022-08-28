class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {

        for (i in 0 until mat.size) {
            val sortedList = getList(i, 0, mat)
            setList(i, 0, mat, sortedList)
        }
        for (i in 1 until mat[0].size) {
            val sortedList = getList(0, i, mat)
            setList(0, i, mat, sortedList)
        }

        return mat
    }

    private fun getList(row: Int, col: Int, mat: Array<IntArray>): List<Int> {
        val mutableList = mutableListOf<Int>()
        var i = row
        var j = col
        while (i < mat.size && j < mat[0].size) {
            mutableList.add(mat[i][j])
            i++
            j++
        }
        return mutableList.toList().sorted()
    }

    private fun setList(row: Int, col: Int, mat: Array<IntArray>, listInt: List<Int>) {
        var i = row
        var j = col
        for (value in listInt) {
            mat[i][j] = value
            i++
            j++
        }
    }
}