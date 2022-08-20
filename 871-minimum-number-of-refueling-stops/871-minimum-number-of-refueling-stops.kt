import java.util.*
import kotlin.math.min


class Solution {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val longStations = stations.toList().map { it.map { it.toLong() }.toLongArray() }

        val concatStations: List<LongArray> =
            listOf(longArrayOf(0, startFuel.toLong())) + longStations +
                    listOf(
                        longArrayOf(target.toLong(), 0)
                    )

        return minRefuelStopTravel(
            targetIdx = stations.size + 1,
            idx = 1,
            currentFuel = startFuel - concatStations[1][0],
            stations = concatStations,
            pq = PriorityQueue(Collections.reverseOrder())
        )
    }

//    특정 위치까지 일단 가고, 가고보니까 가스가 부족하다면 안쓴것 중에 가장 큰 놈을 소비하자.

    private fun minRefuelStopTravel(
        targetIdx: Int,
        idx: Int,
        currentFuel: Long,
        stations: List<LongArray>,
        pq: PriorityQueue<Long>
    ): Int {
        var rechargeFuel = currentFuel
        if (rechargeFuel < 0) {
            while (rechargeFuel < 0) {
                if (pq.isEmpty()) {
                    return -1
                } else {
                    rechargeFuel += pq.poll()
                }
            }
        }
        if (idx == targetIdx) {
            return targetIdx - pq.size - 1
        }
        pq.add(stations[idx][1])
        return minRefuelStopTravel(
            targetIdx = targetIdx,
            idx = idx + 1,
            currentFuel = rechargeFuel - stations[idx + 1][0] + stations[idx][0],
            stations = stations,
            pq = pq
        )

    }
}