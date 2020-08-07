// 211. Add and Search Word - Data structure design

// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// Example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.

	
class WordDictionary {
	private WordDictionary[] children;
	private boolean isEndOfWord;

	/** Initialize your data structure here. */
	public WordDictionary() {
		children = new WordDictionary[26];
		isEndOfWord = false;
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		WordDictionary curr = this;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null)
				curr.children[c - 'a'] = new WordDictionary();
			curr = curr.children[c - 'a'];
		}
		curr.isEndOfWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		WordDictionary curr = this;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (WordDictionary ch : curr.children)
					if (ch != null && ch.search(word.substring(i + 1)))
						return true;
				return false;
			}
			if (curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];
		}
		return (curr != null && curr.isEndOfWord);
	}
}