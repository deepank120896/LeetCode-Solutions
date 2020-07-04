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
		// dp array to store n ugly numbers
		int[] dp = new int[n];
		
		int i2, i3, i5;
		// respective iterators for 2,3,5
		i2 = i3 = i5 = 0;
		// store multiples of 2,3,5 at each step
		int multiple_2 = 2, multiple_3 = 3, multiple_5 = 5;
		int next_ugly = 1;
		int temp;

		// special case
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			// compute next ugly number
			next_ugly = Math.min(multiple_2, Math.min(multiple_3, multiple_5));
			dp[i] = next_ugly;

			// increment multiple of number of which current ugly number is multiple of
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
		// return Nth ugly number
		return dp[n - 1];
	}
}