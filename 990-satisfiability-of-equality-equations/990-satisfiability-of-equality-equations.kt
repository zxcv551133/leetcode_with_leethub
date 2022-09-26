class Solution {
    private val mutableMap = mutableMapOf<Char, Char>()
    
    private fun findParent(c: Char): Char {
        if (mutableMap[c] == null) {
            mutableMap[c] = c
        }
        return if (mutableMap[c]!! == c) c
        else findParent(mutableMap[c]!!)
    }

    private fun unionParent(c1: Char, c2: Char) {
        val p1 = findParent(c1)
        val p2 = findParent(c2)
        if (p1 != p2) {
            if (p1 > p2) {
                mutableMap[p1] = p2
            } else {
                mutableMap[p2] = p1
            }
        }
    }

    fun equationsPossible(equations: Array<String>): Boolean {
        val equals = equations.filter { it.substring(1, 3) == "==" }
        val notEquals = equations.filter { it.substring(1, 3) == "!=" }

        equals.forEach {
            val c1 = it[0]
            val c2 = it[3]
            unionParent(c1, c2)
        }

        notEquals.forEach {
            val c1 = it[0]
            val c2 = it[3]
            if (findParent(c1) == findParent(c2)) return false
        }
        return true
    }
}