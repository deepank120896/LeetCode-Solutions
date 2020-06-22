// 1. Two Sum

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].


// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> hmap = new HashMap<>();

		int pairNum;
		for (int i = 0; i < nums.length; i++) {
			pairNum = target - nums[i];
			if (hmap.containsKey(pairNum)) {
				return new int[] { hmap.get(pairNum), i };
			}
			hmap.put(nums[i], i);
		}
		throw new IllegalArgumentException("Not Found");
	}
}