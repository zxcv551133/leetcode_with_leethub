class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrixCover = Array(n + 2 ) { IntArray(n + 2 ) {-300} }
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrixCover[i + 1][j + 1] = 0
            }
        }

        var stPoint = Pair(1, 0)
        val directions = listOf(Pair(0, 1),Pair(1, 0),Pair(0, -1),Pair(-1, 0))
        var currentDirection = 0
        var currentValue = 1

        fun getNextPoint(current_point: Pair<Int, Int>, direction: Int, origin_direction: Int): Pair<Int, Int> {
            val directionPair = directions[currentDirection]
            val nextPoint = Pair(stPoint.first + directionPair.first, stPoint.second + directionPair.second)
            if(matrixCover[nextPoint.first][nextPoint.second] != 0 && direction == origin_direction) {
                currentDirection = (currentDirection + 1) % 4
                return getNextPoint(current_point, currentDirection, origin_direction)
            }
            return nextPoint
        }
        do {
            stPoint = getNextPoint(stPoint, currentDirection, currentDirection)
            // println(stPoint)
            val currentVal = matrixCover[stPoint.first][stPoint.second]
            if(currentVal != 0) {
                break
            }
            matrixCover[stPoint.first][stPoint.second] = currentValue++
        }
        while(true)
        
        val ret = Array(n ) { IntArray(n ) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                ret[i][j] = matrixCover[i + 1][j + 1]
            }
        }
        
        return ret
    }
}
