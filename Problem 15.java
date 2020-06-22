// 15. 3Sum

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:
// The solution set must not contain duplicate triplets.

// Example:
// Given array nums = [-1, 0, 1, 2, -1, -4],
// A solution set is:
// [
  // [-1, 0, 1],
  // [-1, -1, 2]
// ]


// Method: Sorting + Two Pointer algorithm
// Time Complexity: O(N^2)
// Space Complexity: O(1)

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int top = i + 1;
				int bottom = nums.length - 1;
				int sum = 0 - nums[i];

				while (top < bottom) {
					if (sum < nums[top] + nums[bottom])
						bottom--;
					else if (sum > nums[top] + nums[bottom])
						top++;
					else {
						result.add(Arrays.asList(nums[i], nums[top], nums[bottom]));
						while (top < bottom && nums[top] == nums[top + 1])
							top++;
						while (top < bottom && nums[bottom] == nums[bottom - 1])
							bottom--;
						top++;
						bottom--;
					}
				}
			}
		}
		return result;
	}
}