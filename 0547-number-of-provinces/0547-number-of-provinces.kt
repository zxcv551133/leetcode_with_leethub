class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val visited = BooleanArray(isConnected.size)
        var ret = 0
        for(i in isConnected.indices) {
            if(visited[i]) continue
            ret++
            dfsFindCircleNum(isConnected, visited, i)
        }
        
        return ret
    }

    fun dfsFindCircleNum(isConnected: Array<IntArray>, visited: BooleanArray, currentNode: Int) {
        if(visited[currentNode]) return
        visited[currentNode] = true
        for(nextNode in isConnected.indices) {
            if(currentNode == nextNode || isConnected[currentNode][nextNode] == 0) continue
            dfsFindCircleNum(isConnected, visited, nextNode)
        }
    }
}
