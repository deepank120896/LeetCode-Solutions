// 215. Kth Largest Element in an Array

// Find the kth largest element in an unsorted array. 
// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5

// Example 2:
// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4

// Note:You may assume k is always valid, 1 ≤ k ≤ array's length.



// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
	public int findKthLargest(int[] nums, int k) {
		// create a min Heap to store elements of array
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int num : nums) {
			// add all elements to min Heap
			minHeap.add(num);

			// remove (k-1) elements from min Heap
			if (minHeap.size() > k)
				minHeap.remove();
		}
		// return the Kth Largest element
		return minHeap.remove();
	}
}