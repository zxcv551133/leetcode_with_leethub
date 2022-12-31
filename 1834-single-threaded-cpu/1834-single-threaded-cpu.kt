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
        val firstTask = enqueueTasks.poll()
        pq.add(firstTask)
        var currentTime = firstTask.enqueueTime
        val ret = mutableListOf<Int>()

        while (pq.isNotEmpty()) {
            val currentTask = pq.poll()
            currentTime += currentTask.processingTime
            ret.add(currentTask.index)
            while (enqueueTasks.isNotEmpty()) {
                val candidate = enqueueTasks.peek()
                if (candidate.enqueueTime <= currentTime) {
                    pq.add(candidate)
                    enqueueTasks.poll()
                } else break
            }
            if (pq.isEmpty() && enqueueTasks.isNotEmpty()) {
                val nextTask = enqueueTasks.poll()
                currentTime = nextTask.enqueueTime
                pq.add(nextTask)
                while (enqueueTasks.isNotEmpty()) {
                    val candidate = enqueueTasks.peek()
                    if (candidate.enqueueTime <= currentTime) {
                        pq.add(candidate)
                        enqueueTasks.poll()
                    } else break
                }
            }
        }
        return ret.toIntArray()
    }


}