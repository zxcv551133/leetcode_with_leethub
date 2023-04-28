class Solution {
fun numSimilarGroups(strs: Array<String>): Int {
        var cnt = 0
        val visited = BooleanArray(strs.size)
        val similarGroups = makeSimilarGroups(strs)
        for (i in strs.indices) {
            if (visited[i]) continue
            cnt++
            dfsSimilar(strs, i, visited, similarGroups)
        }

        return cnt
    }

    fun makeSimilarGroups(strs: Array<String>): Array<ArrayList<Int>> {
        val ret = Array(strs.size) { arrayListOf<Int>() }

        for (i in strs.indices) {
            for (j in strs.indices) {
                if(i == j) continue
                if(isSimilar(strs[i], strs[j])) {
                    ret[i].add(j)
                }
            }
        }

        return ret
    }

    fun isSimilar(a: String, b: String): Boolean {
        val diff = arrayListOf<Int>()
        for(i in a.indices) {
            if(a[i] == b[i]) continue
            diff.add(i)
        }
        return diff.size == 0 || (diff.size == 2 && a[diff[0]] == b[diff[1]] && a[diff[1]] == b[diff[0]])
    }

    fun dfsSimilar(strs: Array<String>, currentIdx: Int, visited: BooleanArray, similarGroups: Array<ArrayList<Int>>) {
        if(visited[currentIdx]) return

        visited[currentIdx] = true
        for (idx in similarGroups[currentIdx]) {
            dfsSimilar(strs, idx, visited, similarGroups)
        }
    }
}
