class Trie() {

    private var isEndOfWord = false
    private val children = hashMapOf<Char, Trie>()

    fun insert(word: String) {
        var currNode = this
        for (char in word) {
            currNode = currNode.children.computeIfAbsent(char) { Trie() }
        }
        currNode.setEndOfWord()
    }

    private fun setEndOfWord() {
        isEndOfWord = true
    }

    private fun isEndOfWord(): Boolean {
        return isEndOfWord
    }

    fun search(word: String): Boolean {
        return findNodeOfLastChar(word)?.isEndOfWord() ?: false
    }

    private fun findNodeOfLastChar(word: String): Trie? {
        var currNode = this
        for (char in word) {
            val nextNode = currNode.children[char] ?: return null
            currNode = nextNode
        }
        return currNode
    }

    fun startsWith(prefix: String): Boolean {
        return findNodeOfLastChar(prefix) != null
    }

}
