// 102. Binary Tree Level Order Traversal

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
// 		 3
// 		/ \
// 	   9  20
// 	     /  \
// 	    15   7

// return its level order traversal as:
// [
// [3],
// [9,20],
// [15,7]
// ]


// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new LinkedList<>();

		if (root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			int levelSize = q.size();
			List<Integer> level = new LinkedList<>();

			for (int i = 0; i < levelSize; i++) {

				TreeNode tempNode = q.poll();
				level.add(tempNode.val);

				if (tempNode.left != null)
					q.add(tempNode.left);
				if (tempNode.right != null)
					q.add(tempNode.right);
			}
			result.add(level);
		}
		return result;
	}
}