class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSet: HashSet<Pair<Int, Char>> = hashSetOf()
        val columnSet: HashSet<Pair<Int, Char>> = hashSetOf()
        val boxSet: HashSet<Pair<Pair<Int, Int>, Char>> = hashSetOf()

        for (i in board.indices) {
            for (j in board[i].indices) {
                board[i][j].run {
                    if (this != '.') {
                        if (!rowSet.add(Pair(i, this)) ||
                            !columnSet.add(Pair(j, this)) ||
                            !boxSet.add(Pair(Pair(i / 3, j / 3), this))
                        ) return false
                    }
                }
            }
        }

        return true
    }
}