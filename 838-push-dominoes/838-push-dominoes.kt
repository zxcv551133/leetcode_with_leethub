class Solution {
    fun pushDominoes(dominoes: String): String {
        val patched = "L" + dominoes + "R"
        val zipNext =
            patched.mapIndexed { idx, c -> Pair(c, idx) }
                .filter { (c, _) -> c == 'L' || c == 'R' }
                .zipWithNext()

        val ret = zipNext.map { (current, next) -> pushDominoes(current, next) }
            .reduce { acc, s -> acc.append(s.drop(1)) }.drop(1).dropLast(1)
        zipNext.map { (current, next) -> pushDominoes(current, next) }.forEach { println(it) }
        return ret.toString()
    }

    fun pushDominoes(current: Pair<Char, Int>, next: Pair<Char, Int>): StringBuilder =
        when (Pair(current.first, next.first)) {
            Pair('L', 'L') -> {
                when (next.second) {
                    current.second + 1 -> {
                        StringBuilder("LL")
                    }
                    else -> {
                        pushDominoes(current, Pair(next.first, next.second - 1)).append('L')
                    }
                }
            }
            Pair('L', 'R') -> StringBuilder().append("L" + ".".repeat(next.second - current.second - 1) + "R")
            Pair('R', 'L') -> {
                when (next.second) {
                    current.second + 2 -> {
                        StringBuilder("R.L")
                    }
                    current.second + 1 -> {
                        StringBuilder("RL")
                    }
                    else -> {
                        StringBuilder("R").append(
                            pushDominoes(
                                Pair(current.first, current.second + 1),
                                Pair(next.first, next.second - 1)
                            )
                        ).append("L")
                    }
                }
            }
            Pair('R', 'R') -> {
                when (next.second) {
                    current.second + 1 -> {
                        StringBuilder("RR")
                    }
                    else -> {
                        StringBuilder("R" + pushDominoes(Pair(current.first, current.second + 1), next))
                    }
                }
            }
            else -> throw java.lang.Exception("")
        }
}