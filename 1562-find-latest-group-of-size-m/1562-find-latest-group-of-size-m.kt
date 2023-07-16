class Solution {
    lateinit var parent: IntArray
    lateinit var sizes: IntArray
    var mSizedCount = 0
    
    fun find(a: Int): Int {
        if(parent[a] == a) return a
        parent[a] = find(parent[a])
        return parent[a]
    }
    
    fun union(a: Int, b: Int, m: Int) {
        if(find(a) == find(b)) return
        val u = find(a)
        val v = find(b)
        
        if(sizes[v] == m)  {
            mSizedCount--
        }
        if(sizes[u] == m)  {
            mSizedCount--
        }

        parent[u] = parent[v]
        sizes[v] += sizes[u]
        
        if(sizes[v] == m) {
            mSizedCount++
        }
    }
    
    fun findLatestStep(arr: IntArray, m: Int): Int {
        parent = IntArray(arr.size + 2) { it }
        sizes = IntArray(arr.size + 2)
        val bits = IntArray(arr.size + 2)
        
        var ans = -1
        
        for(stage in arr.indices) {
            val currentChange = arr[stage]
            
            sizes[currentChange] = 1
            
            if(sizes[currentChange] == m) mSizedCount++
            
            bits[currentChange] = 1
            if(bits[currentChange - 1] == 1) {
                union(currentChange, currentChange - 1, m)
            }
            if(bits[currentChange + 1] == 1) {
                union(currentChange, currentChange + 1, m)
            }
            
            if(mSizedCount > 0) ans = stage + 1
        }
        
        return ans
    }
}