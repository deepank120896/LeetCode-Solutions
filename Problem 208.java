// 208. Implement Trie (Prefix Tree)

// Implement a trie with insert, search, and startsWith methods.

// Example:
// Trie trie = new Trie();

// trie.insert("apple");
// trie.search("apple");   // returns true
// trie.search("app");     // returns false
// trie.startsWith("app"); // returns true
// trie.insert("app");   
// trie.search("app");     // returns true

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.

// N: Number of words
// L: max length of strings available
// Time Complexity: O(L)
// Space Complexity: O(L*N)

class Trie {

	private Trie children[];
	private boolean isEnd;

	/** Initialize your data structure here. */
	public Trie() {
		children = new Trie[26];
		isEnd = false;
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie current = this;
		for (char c : word.toCharArray()) {
			if ((current.children[c - 'a']) == null)
				current.children[c - 'a'] = new Trie();
			current = current.children[c - 'a'];
		}
		current.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie current = this;
		for (char c : word.toCharArray()) {
			current = current.children[c - 'a'];
			if (current == null)
				return false;
		}
		if (current.isEnd)
			return true;
		return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie current = this;
		for (char c : prefix.toCharArray()) {
			current = current.children[c - 'a'];
			if (current == null)
				return false;
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */