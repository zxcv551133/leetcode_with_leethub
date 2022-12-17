class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        val operators = setOf("+", "-", "*", "/")
        for (token in tokens) {
            if (!operators.contains(token)) {
                stack.push(token.toInt())
                continue
            }
            val v2 = stack.pop()!!
            val v1 = stack.pop()!!

            when (token) {
                "+" -> stack.push(v1 + v2)
                "-" -> stack.push(v1 - v2)
                "*" -> stack.push(v1 * v2)
                "/" -> stack.push(v1 / v2)
            }
        }
        return stack.pop()
    }
}