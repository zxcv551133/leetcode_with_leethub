class Solution {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val mutableMap = mutableMapOf<String, MutableList<String>>()
        paths.forEach { parseTxt(mutableMap, it) }
        return mutableMap.filterValues { it.size > 1 }.values.map { it.toList() }
    }

    fun parseTxt(mutableMap: MutableMap<String, MutableList<String>>, str: String) {
        val tokens = str.split(" ")
        val path = tokens[0]
        val files = tokens.drop(1).map { fileStr ->
            val idx = fileStr.indexOfFirst { it == '(' }
            val fileName = fileStr.substring(0, idx)
            val fileContext = fileStr.substring(idx + 1, fileStr.length - 1)
            Pair(fileName, fileContext)
        }
        files.forEach { (v, k) ->
            if (mutableMap[k] != null) {
                mutableMap[k]!!.add("$path/$v")
            } else {
                mutableMap[k] = mutableListOf("$path/$v")
            }
        }
    }
}