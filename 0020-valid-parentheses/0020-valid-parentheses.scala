object Solution {
  def isValid(s: String): Boolean = {

    val pMap = Map('('-> ')', '{' -> '}', '[' -> ']')
    var stack:List[Char] = Nil
    for(c <- s) {

      if(pMap.contains(c)) {
        stack = c :: stack
      } else {

        if(stack.isEmpty) return false
        else if(pMap(stack.head) != c) return false
        else stack = stack.tail
      }
    }
    if(stack.isEmpty) true
    else false
  }
}