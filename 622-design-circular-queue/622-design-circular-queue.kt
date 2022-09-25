class MyCircularQueue(k: Int) {
    var frontIdx = 0
    var lastIdx = 0
    val queueArray = IntArray(k)
    val maxSize = k
    var currentSize = 0


    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }

        frontIdx = (frontIdx - 1 + maxSize) % maxSize
        if (isEmpty()) {
            lastIdx = frontIdx
        }
        queueArray[frontIdx] = value
        currentSize += 1
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        lastIdx = (lastIdx + maxSize - 1) % maxSize
        currentSize -= 1
        return true
    }

    fun Front(): Int {
        if (isEmpty()) {
            return -1
        }
        return queueArray[lastIdx]
    }

    fun Rear(): Int {
        if (isEmpty()) {
            return -1
        }
        return queueArray[frontIdx]
    }

    fun isEmpty(): Boolean {
        return currentSize == 0
    }

    fun isFull(): Boolean {
        return currentSize == maxSize
    }
}