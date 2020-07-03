// 107. Binary Tree Level Order Traversal II

// Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
// (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
// 		3
// 	   / \
//    9  20
//      /  \
//     15   7
// return its bottom-up level order traversal as:
// [
// [15,7],
// [9,20],
// [3]
// ]

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		if (root == null)
			return new ArrayList();

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();

			while (size-- > 0) {
				root = q.poll();
				level.add(root.val);

				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
			}
			result.add(level);
		}
		Collections.reverse(result); // O(l): l= number of levels
		return result;
	}
}