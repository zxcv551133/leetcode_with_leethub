class Solution {
    data class Node(val x: Int, val y: Int, val obs: Int, val dist: Int)
    
    val dirs = arrayOf(intArrayOf(0,1),intArrayOf(0,-1),intArrayOf(1,0),intArrayOf(-1,0))
    
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        
        val queue = LinkedList<Node>()
        val visited = Array(grid.size) { Array(grid[0].size) { BooleanArray(grid[0].size * grid.size + 1) } }
        
        queue.offer(Node(0, 0, k, 0))
        
        while(queue.isNotEmpty()) {
            val node = queue.poll()
            var x = node.x
            var y = node.y
            var obs = node.obs
            var dist = node.dist
            
            if(visited[x][y][obs]) continue
            visited[x][y][obs] = true
            
            if(x == grid.lastIndex && y == grid[0].lastIndex) {
                return dist
            }
            
            dirs.forEach { dir ->
                val x = x + dir[0]
                val y = y + dir[1]
                
                if(x < 0 || x >= grid.size || y < 0 || y >= grid[0].size) return@forEach
                
                if(grid[x][y] == 1 && obs > 0) {
                    queue.offer(Node(x, y, obs - 1, dist + 1))
                } else if(grid[x][y] == 0) {
                    queue.offer(Node(x, y, obs, dist + 1))
                }
            }
        }
        
        return -1
    }
}