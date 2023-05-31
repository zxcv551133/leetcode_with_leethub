class TicTacToe(val n: Int) {
    val vertical = IntArray(n)
    val horizontal = IntArray(n)
    var diagonal1 = 0
    var diagonal2 = 0

    fun move(row: Int, col: Int, player: Int): Int {
        val playerVal = if(player == 2) -1 else 1
        vertical[row] += playerVal
        if(kotlin.math.abs(vertical[row]) == n) return player
        horizontal[col] += playerVal
        if(kotlin.math.abs(horizontal[col]) == n) return player
        if(row == col) {
            diagonal1 += playerVal
            if(kotlin.math.abs(diagonal1) == n) return player
        }
        if(row + col == n - 1) {
            diagonal2 += playerVal
            if(kotlin.math.abs(diagonal2) == n) return player
        }
        return 0
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * var obj = TicTacToe(n)
 * var param_1 = obj.move(row,col,player)
 */
 