class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        

        val prerequisiteGraph = Array(numCourses) { mutableListOf<Int>() }
        for (prerequisite in prerequisites) {
            prerequisiteGraph[prerequisite[1]].add(prerequisite[0])
        }
        
        
        val visited = BooleanArray(numCourses)
        val cycle = BooleanArray(numCourses)
        for (i in 0 until numCourses) {
            if(visited[i]) continue
            if (dfsFindCycle(i, prerequisiteGraph, visited, cycle)) return false
        }
        return true
    }

    fun dfsFindCycle(course: Int, prerequisiteGraph: Array<MutableList<Int>>, visited: BooleanArray, cycle: BooleanArray): Boolean {
        if(cycle[course]) return true
        if (visited[course]) return false
        visited[course] = true
        cycle[course] =true
        
        for (prerequiste in prerequisiteGraph[course]) {
            if (dfsFindCycle(prerequiste, prerequisiteGraph, visited, cycle)) return true
        }
        cycle[course] = false
        return false
    }
}
