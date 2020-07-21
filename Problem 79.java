// 79. Word Search

// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:
// board =
// [
  // ['A','B','C','E'],
  // ['S','F','C','S'],
  // ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
 

// Constraints:
// board and word consists only of lowercase and uppercase English letters.
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3


// Time Complexity: O(N)
// Space Complexity: O(N) - Recursive calls

class Solution {
	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if first letter of word matches then only proceed to DFS
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0))
					return true;
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int i, int j, String word, int count) {
		// at last letter of word
		if (count == word.length())
			return true;
		// boundary conditions for board
		// does board current char matched with word current char
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count))
			return false;
		
		// keep record for visited
		char temp = board[i][j];
		board[i][j] = ' ';
		// recursive dfs in 4 directions
		boolean found = dfs(board, i - 1, j, word, count + 1) || dfs(board, i + 1, j, word, count + 1)
				|| dfs(board, i, j - 1, word, count + 1) || dfs(board, i, j + 1, word, count + 1);

		// restore board character if DFS return false
		board[i][j] = temp;
		return found;
	}
}
