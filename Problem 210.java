// 210. Course Schedule II

// There are a total of n courses you have to take, labeled from 0 to n-1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
// There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

// Example 1:
// Input: 2, [[1,0]] 
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1] .
			 
// Example 2:
// Input: 4, [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,1,2,3] or [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.


class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] adj = createAdjacencyList(numCourses, prerequisites);
		int[] result = topoLogicalDFS(numCourses, adj);
		return result;
	}

	// create adjacency list for directed graph using given data
	public List<Integer>[] createAdjacencyList(int numCourses, int[][] prerequisites) {
		List<Integer>[] adj = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<Integer>();
		for (int[] courses : prerequisites)
			adj[courses[1]].add(courses[0]);
		return adj;
	}

	// Perform topological ordering
	public int[] topoLogicalDFS(int numCourses, List<Integer>[] adj) {
		List<Integer> stack = new LinkedList();
		int[] visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			if (visited[i] == 0 && cyclicDFS(i, adj, stack, visited))
				return new int[0];
		Collections.reverse(stack);
		int[] result = stack.stream().mapToInt(Integer::intValue).toArray();
		return result;
	}

	// Check for cycle and do DFS
	public boolean cyclicDFS(int u, List<Integer>[] adj, List<Integer> stack, int[] visited) {
		visited[u] = 1;
		for (int v : adj[u]) {
			if (visited[v] == 1)
				return true;
			if (visited[v] == 0 && cyclicDFS(v, adj, stack, visited))
				return true;
		}
		visited[u] = 2;
		stack.add(u);
		return false;
	}
}