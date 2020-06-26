// 287. Find the Duplicate Number

// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

// Input: [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: [3,1,3,4,2]
// Output: 3

// Note:
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.

// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
	public int findDuplicate(int[] nums) {

		// using floyd tortoise and hare cycle detection algorithm
		int fast, slow;
		fast = slow = 0;

		// to detect cycle
		do {
			fast = nums[nums[fast]]; // moves at 2x speed
			slow = nums[slow]; // moves at 1x speed
		} while (fast != slow);

		fast = 0;
		// to find enterance of cycle
		while (fast != slow) {
			// both pointers move at 1x speed
			fast = nums[fast];
			slow = nums[slow];
		}

		// return anyone pointer as both point to same element now
		return fast;

	}
}