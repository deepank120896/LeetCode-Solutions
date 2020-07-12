// 78. Subsets

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:
// Input: nums = [1,2,3]
// Output:
// [
// 	[3],
// 	[1],
// 	[2],
// 	[1,2,3],
// 	[1,3],
// 	[2,3],
// 	[1,2],
// 	[]
// ]

// Iterative BFS
class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList();
		result.add(new ArrayList());
		for (int num : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subset = new ArrayList(result.get(i));
				subset.add(num);
				result.add(subset);
			}
		}
		return result;
	}
}