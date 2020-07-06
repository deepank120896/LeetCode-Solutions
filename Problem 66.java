// 66. Plus One

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.

// Example 2:
// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
	public int[] plusOne(int[] digits) {

		int n = digits.length;
		// traverse number last digit to first digit
		for (int i = n - 1; i >= 0; i--) {
			// if current digit less than 9 just increment itself
			// [4,8],[4,6,7],[4,3,2,1]
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			// last n-1 digits are equal to 9
			// convert all 9's to 0
			digits[i] = 0;
		}
		// add an extra 1
		// [9,9]->>[1,0,0]; [9,9,9,9]->>[1,0,0,0,0]
		int[] newNum = new int[n + 1];
		newNum[0] = 1;
		return newNum;
	}
}