// 27. Remove Element

// Given an array nums and a value val, remove all instances of that value in-place and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

// Example 1:
// Given nums = [3,2,2,3], val = 3,
// Your function should return length = 2, with the first two elements of nums being 2.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
	public int removeElement(int[] nums, int val) {

		// using two pointers [ i , j]
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			// change values only when current element no equals value
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
