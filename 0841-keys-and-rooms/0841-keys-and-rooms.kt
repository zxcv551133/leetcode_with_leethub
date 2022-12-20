class Solution {
    private val visited = mutableSetOf<Int>()
    lateinit var rooms: List<List<Int>>
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        this.rooms = rooms
        visitRoom(0)
        return visited.size == rooms.size
    }

    fun visitRoom(idx: Int) {
        if (idx in visited) return
        visited.add(idx)
        for (key in rooms[idx]) {
            visitRoom(idx = key)
        }
    }
}