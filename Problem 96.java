// 96. Unique Binary Search Trees

// Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

// Example:

// Input: 3
// Output: 5
// Explanation:
// Given n = 3, there are a total of 5 unique BST's:

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

class Solution {
	public int numTrees(int n) {

		// to store memoization for n nodes
		int[] dp = new int[n + 1];
		

		dp[0] = 1; // NULL BST
		dp[1] = 1; // Single Node BST

		for (int i = 2; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++)
				// dp[5] = dp[0][5]+dp[1][4]+dp[2][3]+dp[3][2]+dp[4][1]+dp[5][0]
				dp[i] += dp[j] * dp[i - j - 1];
		}
		return dp[n];
	}
}