class Solution {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        class Task(val enqueueTime: Int, val processingTime: Int, val index: Int)

        val classedTasks =
            tasks.mapIndexed { idx, ar -> Task(enqueueTime = ar[0], processingTime = ar[1], index = idx) }
        val enqueueTasks = PriorityQueue<Task>(
            Comparator<Task> { a, b -> a.enqueueTime.compareTo(b.enqueueTime) }
                .thenComparator { a, b -> a.processingTime.compareTo(b.processingTime) }
                .thenComparator { a, b -> a.index.compareTo(b.index) })
        classedTasks.forEach { enqueueTasks.add(it) }
        val pq = PriorityQueue<Task>(
            Comparator<Task> { a, b -> a.processingTime.compareTo(b.processingTime) }
                .thenComparator { a, b -> a.index.compareTo(b.index) })

        var currentTime = 0
        val ret = mutableListOf<Int>()

        do {
            if (pq.isEmpty()) {
                val nextTask = enqueueTasks.poll()
                if (currentTime < nextTask.enqueueTime) {
                    currentTime = nextTask.enqueueTime
                }
                pq.add(nextTask)
            }
            while (enqueueTasks.isNotEmpty()) {
                val candidate = enqueueTasks.peek()
                if (candidate.enqueueTime <= currentTime) {
                    pq.add(candidate)
                    enqueueTasks.poll()
                } else break
            }
            val currentTask = pq.poll()
            currentTime += currentTask.processingTime
            ret.add(currentTask.index)
        } while (pq.isNotEmpty() || enqueueTasks.isNotEmpty())
        return ret.toIntArray()
    }
}
