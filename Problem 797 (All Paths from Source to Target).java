// 797. All Paths From Source to Target

// Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

// The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

// Example:
// Input: [[1,2], [3], [3], []] 
// Output: [[0,1,3],[0,2,3]] 

// Explanation: The graph looks like this:
// 0--->1
// |    |
// v    v
// 2--->3
// There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.


// Note:
// The number of nodes in the graph will be in the range [2, 15].
// You can print different paths in any order, but you should keep the order of nodes inside one path.


// Time Complexity: O(N^2 * 2^N)
// Space Complexity: O(2^N)

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList();
        Queue<List<Integer>> q = new LinkedList();
        q.add(Arrays.asList(0));
        int goal = graph.length-1;
        
        while(!q.isEmpty()){
            List<Integer> path = q.poll();
            int lastNodeOfPath = path.get(path.size()-1);
            if(lastNodeOfPath == goal)
                result.add(path);
            else
            {
                int[] neighbours = graph[lastNodeOfPath];
                for(int n: neighbours){
                    List<Integer> l = new ArrayList(path);
                    l.add(n);
                    q.add(l);
                }
            }
        }
        return result;
    }
}