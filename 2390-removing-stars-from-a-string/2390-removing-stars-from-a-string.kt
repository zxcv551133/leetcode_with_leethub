class Solution {
    fun removeStars(s: String): String {
        val charAr = s.toCharArray()

        val treeSet = TreeSet<Int>()
        treeSet.add(-1)

        for (i in s.indices) {
            if(s[i] != '*') {
                treeSet.add(i)
            }

            if(charAr[i] == '*' && treeSet.last()!! >= 0) {
                charAr[treeSet.last()!!] = '*'
                treeSet.remove(treeSet.last()!!)
            }
        }

        return charAr.filterNot { it == '*' }.joinToString("")
    }
}
