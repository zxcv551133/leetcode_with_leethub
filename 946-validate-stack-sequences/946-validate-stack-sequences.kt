import java.util.*

class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var idx = 0
        popped.forEach { popValue ->
            while (idx < pushed.size && (stack.isEmpty() || stack.peek() != popValue)) {
                stack.push(pushed[idx++])
            }
            if (stack.peek() == popValue) {
                stack.pop()
            } else {
                return false
            }
        }
        return true
    }
}