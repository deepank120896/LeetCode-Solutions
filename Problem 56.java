// 56. Merge Intervals

// Given a collection of intervals, merge all overlapping intervals.

// Example 1:
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

// Example 2:
// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// Time Complexity: O(N.logN)
// Space Complexity: O(1)

class Solution {
	public int[][] merge(int[][] intervals) {
		// base case: if input is empty or has only 1 interval
		if (intervals.length == 1 || intervals.length == 0)
			return intervals;

		// sorting intervals by start-time in ascending order
		Arrays.sort(intervals, (ar1, ar2) -> Integer.compare(ar1[0], ar2[0]));

		// result to store list of modiefied intervals
		List<int[]> result = new ArrayList<>();

		int[] current_interval = intervals[0];
		result.add(current_interval);

		// traverse intervals array
		for (int[] interval : intervals) {
			int current_begin = current_interval[0];
			int current_end = current_interval[1];
			int next_begin = interval[0];
			int next_end = interval[1];

			// if current-interval-end is greater than or equal to next-interval-beginning
			// merge the current and next intervals
			if (current_end >= next_begin) {
				current_interval[1] = Math.max(current_end, next_end);
			}
			// else add next interval to result list
			else {
				current_interval = interval;
				result.add(current_interval);
			}
		}
		// create a 2-D array from result list and return
		return result.toArray(new int[result.size()][]);
	}
}