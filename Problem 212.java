// 212. Word Search II
// Given a 2D board and a list of words from the dictionary, find all words in the board.

// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

// Example:

// Input: 
// board = [
// ['o','a','a','n'],
// ['e','t','a','e'],
// ['i','h','k','r'],
// ['i','f','l','v']
// ]

// words = ["oath","pea","eat","rain"]

// Output: ["eat","oath"]

// Note:
// All inputs are consist of lowercase letters a-z.
// The values of words are distinct.

// Trie Implementation
class Trie {
	public Trie children[];
	public boolean isEndOfWord;

	public Trie() {
		isEndOfWord = false;
		children = new Trie[26];
		for (int i = 0; i < 26; i++)
			children[i] = null;
	}

	// insert word in a trie
	public void insert(String word) {
		Trie current = this;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new Trie();
			current = current.children[c - 'a'];
		}
		current.isEndOfWord = true;
	}
}

class Solution {
	// DFS to traverse adjacents of current character
	private void DFS(char[][] board, int i, int j, HashSet<String> result, Trie trie, String s) {
		char c = board[i][j];
		if (c == '$') // already visited for current word
			return;

		board[i][j] = '$'; // mark visited for current word
		Trie t = trie.children[c - 'a'];

		if (t != null) {
			String ss = s + c;

			if (t.isEndOfWord)
				result.add(ss);

			if (i < board.length - 1)
				DFS(board, i + 1, j, result, t, ss); // right

			if (j < board[0].length - 1)
				DFS(board, i, j + 1, result, t, ss); // down

			if (i > 0)
				DFS(board, i - 1, j, result, t, ss); // left

			if (j > 0)
				DFS(board, i, j - 1, result, t, ss); // up
		}
		board[i][j] = c; // unmark visited for current word
	}

	public List<String> findWords(char[][] board, String[] words) {
		if (words.length == 0)
			return new ArrayList<String>();

		Trie trie = new Trie();
		for (String w : words)
			trie.insert(w);

		HashSet<String> result = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				DFS(board, i, j, result, trie, "");
			}
		}

		ArrayList<String> foundWords = new ArrayList(result);
		return foundWords;
	}
}