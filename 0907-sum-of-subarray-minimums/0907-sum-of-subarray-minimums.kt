class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        val MOD = 1000000007

        val stack = Stack<Int>()
        var sumResult: Long = 0
        for (i in 0..arr.size) {
            while (!stack.isEmpty() && (i == arr.size || arr[stack.peek()] >= arr[i])) {
                val current = stack.pop()
                val left = if (stack.isEmpty()) -1 else stack.peek()
                val currentSum = (arr[current].toLong() * (i - current) * (current - left)) % MOD
                sumResult = (sumResult + currentSum) % MOD
            }
            stack.push(i)
        }

        return sumResult.toInt()
    }
}