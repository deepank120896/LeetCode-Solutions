// 264. Ugly Number II

// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

// Example:
// Input: n = 10
// Output: 12
// Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

// Note:  
// 1 is typically treated as an ugly number.
// n does not exceed 1690.


// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
	public int nthUglyNumber(int n) {

		int[] dp = new int[n];
		int i2, i3, i5;
		i2 = i3 = i5 = 0;
		int multiple_2 = 2, multiple_3 = 3, multiple_5 = 5;
		int next_ugly = 1;
		int temp;

		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			next_ugly = Math.min(multiple_2, Math.min(multiple_3, multiple_5));
			dp[i] = next_ugly;

			if (next_ugly == multiple_2) {
				i2++;
				multiple_2 = dp[i2] * 2;
			}
			if (next_ugly == multiple_3) {
				i3++;
				multiple_3 = dp[i3] * 3;
			}
			if (next_ugly == multiple_5) {
				i5++;
				multiple_5 = dp[i5] * 5;
			}
		}
		return dp[n - 1];
	}
}