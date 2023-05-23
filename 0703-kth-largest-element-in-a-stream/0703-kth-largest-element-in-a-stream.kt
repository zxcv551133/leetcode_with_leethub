class KthLargest(val k: Int, nums: IntArray) {

    val remains = mutableListOf<Int>()
    val minHeap = PriorityQueue<Int>()
    
    init {
        for (num in nums) {
            minHeap.add(num)
        }
    }
        
    fun add(`val`: Int): Int {
        minHeap.add(`val`)
        while(minHeap.size > k) {
            remains.add(minHeap.poll()!!)
        }
        return minHeap.peek()!!
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
 