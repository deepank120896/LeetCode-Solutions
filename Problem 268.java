// 268. Missing Number

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1:
// Input: [3,0,1]
// Output: 2
// Example 2:

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8

// Note:
// Your algorithm should run in linear runtime complexity. 
// Could you implement it using only constant extra space complexity?

class Solution {
	public int missingNumber(int[] nums) {

		// variables to store XOR of indicies and array elements
		int a, b;
		a = 0;
		b = nums[0];

		// all numbers between 0 to n
		for (int i = 1; i <= nums.length; i++)
			a = a ^ i;

		// elements present in array
		for (int i = 1; i < nums.length; i++)
			b = b ^ nums[i];

		return a ^ b;
	}
}