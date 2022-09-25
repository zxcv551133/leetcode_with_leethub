class MyCircularQueue(private val k: Int) {
    var frontIdx = 0
    var lastIdx = 0
    val queueArray = IntArray(k) { -1 }
    
    fun enQueue(value: Int): Boolean {
        if (isFull()) return false

        queueArray[frontIdx] = value
        frontIdx = (frontIdx + 1) % k

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false

        queueArray[lastIdx] = -1
        lastIdx = (lastIdx + 1) % k
        return true
    }

    fun Front(): Int = queueArray[lastIdx]

    fun Rear(): Int = queueArray[(frontIdx - 1 + k) % k]

    fun isEmpty(): Boolean = lastIdx == frontIdx && queueArray[lastIdx] == -1

    fun isFull(): Boolean = lastIdx == frontIdx && queueArray[lastIdx] != -1
}