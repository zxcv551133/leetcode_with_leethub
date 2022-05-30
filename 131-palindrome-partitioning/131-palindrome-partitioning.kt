class Solution {
    class Memoize<T, R>(val func: (T) -> R) {
        private val cache = mutableMapOf<T, R>()
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>) = { n: T ->
            cache.getOrPut(n) { func(n) }
        }
    }

    val isPalindrome: (String) -> Boolean by Memoize { str ->
        when (str.length) {
            0 -> false
            1 -> true
            2 -> str[0] == str[1]
            else -> {
                if (str[0] == str[str.length - 1]) {
                    isPalindrome(str.substring(1, str.length - 1))
                } else {
                    false
                }
            }
        }
    }

    val memoizedPartition: (String) -> List<List<String>> by Memoize { str ->
        if (str.length == 1) {
            listOf(listOf(str))
        } else {
            val partitions =
                str.foldIndexed(listOf<List<String>>()) { idx, acc, c ->
                    val currentSubstr = str.substring(0, idx)
                    if (isPalindrome(currentSubstr)) {
                        acc + memoizedPartition(str.substring(idx, str.length)).map { listOf(currentSubstr) + it }
                    } else {
                        acc
                    }
                }.toSet().toList()
            if (isPalindrome(str))
                listOf(listOf(str)) + partitions
            else
                partitions
        }
    }

    fun partition(s: String): List<List<String>> {
        return memoizedPartition(s)
    }
}