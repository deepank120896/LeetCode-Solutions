// 485. Max Consecutive Ones

// Given a binary array, find the maximum number of consecutive 1s in this array.

// Example 1:
// Input: [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s.
// The maximum number of consecutive 1s is 3.

// Note:
// The input array will only contain 0 and 1.
// The length of input array is a positive integer and will not exceed 10,000

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {

		int currentMax = 0;
		int max = 0;

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == 1) {
				currentMax++;
				max = Math.max(currentMax, max);
			} else {
				currentMax = 0;
			}
		}
		return max;
	}
}