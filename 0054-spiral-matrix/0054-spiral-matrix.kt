class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val matrixCover = Array(matrix.size + 2) { IntArray(matrix[0].size + 2) {-300} }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                matrixCover[i + 1][j + 1] = matrix[i][j]
            }
        }

        val ret = mutableListOf<Int>()
        var stPoint = Pair(1, 0)
        val directions = listOf(Pair(0, 1),Pair(1, 0),Pair(0, -1),Pair(-1, 0))
        var currentDirection = 0

        fun getNextPoint(current_point: Pair<Int, Int>, direction: Int, origin_direction: Int): Pair<Int, Int> {
            val directionPair = directions[currentDirection]
            // println("$currentDirection, $directionPair")
            val nextPoint = Pair(stPoint.first + directionPair.first, stPoint.second + directionPair.second)
            // println("$nextPoint")
            if(matrixCover[nextPoint.first][nextPoint.second] == -300 && direction == origin_direction) {
                currentDirection = (currentDirection + 1) % 4
                return getNextPoint(current_point, currentDirection, origin_direction)
            }
            return nextPoint
        }
        do {
            stPoint = getNextPoint(stPoint, currentDirection, currentDirection)
            // println(stPoint)
            val currentVal = matrixCover[stPoint.first][stPoint.second]
            if(currentVal == -300) {
                break
            }
            matrixCover[stPoint.first][stPoint.second] = -300
            ret.add(currentVal)
        }
        while(!(matrixCover[stPoint.first + 1][stPoint.second] == -300 &&
            matrixCover[stPoint.first][stPoint.second + 1] == -300 &&
            matrixCover[stPoint.first - 1][stPoint.second] == -300 &&
            matrixCover[stPoint.first][stPoint.second - 1] == -300))

        return ret.toList()
    }
}
