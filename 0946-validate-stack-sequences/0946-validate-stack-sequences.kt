class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var currentPos = 0
        for ( num in popped ) {
            while((stack.isEmpty() || stack.peek() != num) && currentPos < pushed.size) {
                stack.push(pushed[currentPos])
                currentPos++
            }
            if(stack.isEmpty() || stack.pop() != num) {
                return false
            }
        }
        return true
    }
}
