class Solution {
    fun simplifyPath(path: String): String {
        val tokenStack = Stack<String>()
        tokenStack.push("/")
        for (token in path.split("/")) {
            // println(token)
            if (token == "") {
                continue
            }
            else if (token == "..") {
                if(tokenStack.size > 1) {
                    tokenStack.pop()
                }
            }
            else if (token == ".") {
                continue
            }
            else {
                tokenStack.push(token)
            }
        }

        // println(tokenList)
        
        val tokenList = tokenStack.toList()
        val tokenString = tokenList.joinToString("/")
        val removeDoubleDash = tokenString.replace("//", "/")

        return removeDoubleDash
    }
}
