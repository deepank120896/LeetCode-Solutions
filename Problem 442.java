// Find All Duplicates in an Array
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
// Find all the elements that appear twice in this array.

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [2,3]


// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> result = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			// Make each number positive , to get number through index
			int index = Math.abs(nums[i]) - 1;
			// if number is -ve then it is repeated
			if (nums[index] < 0)
				result.add(index + 1);
			// negate each number
			nums[index] = -nums[index];
		}
		return result;
	}
}