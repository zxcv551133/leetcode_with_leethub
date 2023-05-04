class Solution {
    fun predictPartyVictory(senate: String): String {
        var radiant = 0
        var radiantSt = 0
        var dire = 0
        var direSt = 0

        val q: Queue<Char> = LinkedList<Char>()

        for (c in senate) {
            q.add(c)
            if(c == 'R') {
                radiant++
            } else {
                dire++
            }
        }

        while(radiant > 0 && dire > 0) {
            val c = q.poll()

            if(c == 'R') {
                if(direSt > 0) {
                    direSt--
                    radiant--
                } else {
                    radiantSt++
                    q.add(c)
                }
            } else if(c == 'D') {
                if(radiantSt > 0) {
                    radiantSt--
                    dire--
                } else {
                    direSt++
                    q.add(c)
                }
            }
        }

        return if(radiant > 0) "Radiant" else "Dire"
    }

}
