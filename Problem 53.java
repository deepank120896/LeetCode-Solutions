// 53. Maximum Subarray

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

class Solution {
	public int maxSubArray(int[] nums) {

		// assigning with minimum value possible
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < nums.length; i++) {
			// check whether current element greater than currentSum+element
			currentSum = Math.max(currentSum + nums[i], nums[i]);
			maxSum = Math.max(currentSum, maxSum);
		}
		// return max-Sum found
		return maxSum;
	}
}