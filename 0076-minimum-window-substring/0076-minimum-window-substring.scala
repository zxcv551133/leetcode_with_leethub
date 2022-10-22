object Solution {
  def minWindow(s: String, t: String): String = {


    val sMap = collection.mutable.Map[Char,Int]()
    // sMap 에는 remaining 을 다 채우기 위해 필요한 원소들만 들어가게된다.

    for(i <- 0 to 128) {
      sMap.put(i.toChar, 0)
    }
    t.foreach(e => sMap.put(e, sMap(e) + 1))
    var l = 0
    var r = 0
    var remaining = t.length
    var minLength = s.length + 2
    var minIdx = -1
    while(r < s.length) {
      // sMap 이 이미 s(r) 원소를 가지고 있었다면 remaining 을 감소시킬 필요가있음
      if(sMap(s(r)) >= 1) {
        // println(s(r))
        remaining -= 1
      }
      // r 을 1 증가시키고, sMap(s(r)) 을 1 감소
      sMap.put(s(r), sMap(s(r)) - 1)
      r += 1


      // 만일 remaining 이 0 이라면 만족하고 있음을 뜻하므로

      while(remaining == 0) {

        // 최소값이라면 새로고침
        if(r - l < minLength) {
          minIdx = l
          minLength = r - l
        }

        // 만일 sMap에 s(l) 원소가 존재한다면 해당하는 것을 없애는 것이므로 remaining 을 하나 더하고
        if (sMap(s(l)) >= 0) remaining += 1
        // 존재하건 안하건 sMap 에서도 필요원소값을 하나 증가시키고 l은 1증가시킨다.
        sMap.put(s(l), sMap(s(l)) + 1)
        l += 1
      }
    }
    if(minIdx == -1) {
      ""
    } else {
      s.substring(minIdx,minIdx + minLength)
    }
  }
}