// 347. Top K Frequent Elements

// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]
// Note:

// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
// It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
// You can return the answer in any order.


// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> hm = createFrequencyMap(nums);
		List<Integer>[] bucket = createBucket(hm, nums);
		int[] result = selectTopK(bucket, k);
		return result;
	}
	
	// Create frequency Map as per elements present
	public Map<Integer, Integer> createFrequencyMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return map;
	}
	
	// create a bucket of distinct frequencies present
	public List<Integer>[] createBucket(Map<Integer, Integer> hm, int[] nums) {
		List<Integer>[] bucket = new ArrayList[nums.length + 1];
		for (int num : hm.keySet()) {
			int freq = hm.get(num);
			if (bucket[freq] == null)
				bucket[freq] = new ArrayList();
			bucket[freq].add(num);
		}
		return bucket;
	}
	
	// select top k frequency elements
	public int[] selectTopK(List<Integer>[] bucket, int k) {
		int[] top = new int[k];
		int index = 0;
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (int num : bucket[i]) {
					top[index++] = num;
					if (index == k)
						return top;
				}
			}
		}
		return top;
	}
}