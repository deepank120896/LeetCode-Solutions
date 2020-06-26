// 238. Product of Array Except Self

// Given an array nums of n integers where n > 1,  
// return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Example:
// Input:  [1,2,3,4]
// Output: [24,12,8,6]
// Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

// Note: Please solve it without division and in O(n).

// Follow up:
// Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
	public int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		// array to store and return result
		int[] result = new int[n];

		// since, no element present before first element
		result[0] = 1;
		
		// traverse from second to last
		// keep multiplying elements before current element
		// left-product
		for (int i = 1; i < n; i++)
			result[i] = result[i - 1] * nums[i - 1];

		// calculate right-product and multiply with output
		// traverse right to left and keep multiplying elements on right of current
		// element
		int R = 1;
		
		for (int i = n - 1; i >= 0; i--) {
			result[i] = result[i] * R;
			R = R * nums[i];
		}
		return result;
	}
}