// 283. Move Zeroes

// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
	public void moveZeroes(int[] nums) {

		// using two pointers
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			// if current element not zero then bring to front
			if (nums[j] != 0)
				nums[i++] = nums[j];
		}
		// set left out elements to zero
		while (i < nums.length) {
			nums[i++] = 0;
		}
	}
}