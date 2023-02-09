class Solution {
    fun distinctNames(ideas: Array<String>): Long {

        var ans: Long = 0L

        val ideasMap = mutableMapOf<Char,MutableSet<String>>().apply{
            ideas.forEach{ idea ->
                putIfAbsent(idea[0], mutableSetOf<String>())
                get(idea[0])!!.add(idea.substring(1,idea.length))
            }
        }

        val ideasList = ideasMap.keys.toList()

        for(i in ideasList.indices){
            for(j in i + 1 until ideasList.size){
                val setA: Set<String> = ideasMap[ideasList[i]]!!
                val setB: Set<String> = ideasMap[ideasList[j]]!!

                val unionSet: MutableSet<String> = HashSet()
                unionSet.addAll(setA)
                unionSet.addAll(setB)

                ans += 2 * (setA.size - unionSet.size) * (setB.size - unionSet.size)
            }
        }
        
        return ans
    }
}