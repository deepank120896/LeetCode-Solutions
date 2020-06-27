// 279. Perfect Squares

// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// Example 1:
// Input: n = 12
// Output: 3 
// Explanation: 12 = 4 + 4 + 4.

// Example 2:
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

// Time Complexity: O(n^3/2)
// Space Complexity: O(n)

class Solution {
	public int numSquares(int n) {

		// dp array to store value of sub-problems
		int dp[] = new int[n + 1];

		// traverse all elements before n
		for (int x = 1; x <= n; x++) {
			// minimum value to store per iteration
			// worst case: all 1's
			int min_val = x;
			int y = 1, sq = 1;

			// loop runs root-n times to calculate squares upto n
			while (sq <= x) {
				// calculate minimum of current min and remaining value, after subtracting
				// square
				min_val = Math.min(min_val, 1 + dp[x - sq]);
				y++;
				sq = y * y;
			}
			dp[x] = min_val;
		}
		// return solution for n
		return dp[n];
	}
}