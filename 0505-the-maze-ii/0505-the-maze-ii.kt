class Solution {
    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        val newMaze = Array(maze.size + 2) { IntArray(maze[0].size + 2) { 1 } }
        for (row in maze.indices) {
            for (col in maze[0].indices) {
                newMaze[row + 1][col + 1] = maze[row][col]
            }
        }
        return shortestDistance(
            maze = newMaze,
            start = Pair(start[0] + 1, start[1] + 1),
            destination = Pair(destination[0] + 1, destination[1] + 1)
        ) ?: -1
    }

    private fun shortestDistance(maze: Array<IntArray>, start: Pair<Int, Int>, destination: Pair<Int, Int>): Int? {
        val distances = mutableMapOf<Pair<Int, Int>, Int?>()
        val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
        val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>> { a, b -> a.second - b.second }
        pq.add(Pair(start, 0))
        while (pq.isNotEmpty()) {
            val (current, dist) = pq.poll()
            // if (distances[current]?.let { it < dist } == true)
            //     continue

            for (dir in directions) {
                var next = current
                var cnt = 0
                while (maze[next.first + dir.first][next.second + dir.second] == 0) {
                    next = Pair(next.first + dir.first, next.second + dir.second)
                    cnt++
                }
                if (distances[next]?.let { it <= cnt + dist } == true) {
                    continue
                }
                distances[next] = dist + cnt
                pq.add(Pair(next, dist + cnt))
            }
        }

        return distances[destination]
    }
}