// 260. Single Number III

// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// Example:
// Input:  [1,2,1,3,2,5]
// Output: [3,5]

// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
	public int[] singleNumber(int[] nums) {
		int xy = 0;
		int result[] = new int[2];
		for (int num : nums)
			xy ^= num;
		xy &= -xy;
		for (int num : nums)
			if ((xy & num) != 0)
				result[0] ^= num;
			else
				result[1] ^= num;
		return result;
	}
}