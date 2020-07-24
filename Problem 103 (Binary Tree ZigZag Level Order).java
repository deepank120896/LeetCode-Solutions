// 103. Binary Tree Zigzag Level Order Traversal

// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
    // 3
   // / \
  // 9  20
    // /  \
   // 15   7
   
// return its zigzag level order traversal as:
// [
  // [3],
  // [20,9],
  // [15,7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 
// N - Number of nodes in Binary Tree
// Time Complexity: O(N)
// Space Complexity: O(N)+O(N)
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> zigzag = new ArrayList();
		List<Integer> currentLevel = new ArrayList();

		if (root == null)
			return zigzag;

		Stack<TreeNode> rightToLeft = new Stack();
		Stack<TreeNode> leftToRight = new Stack();

		rightToLeft.push(root);

		while (!rightToLeft.isEmpty() || !leftToRight.isEmpty()) {
			while (!rightToLeft.isEmpty()) {
				TreeNode n = rightToLeft.pop();
				currentLevel.add(n.val);
				if (n.left != null)
					leftToRight.push(n.left);
				if (n.right != null)
					leftToRight.push(n.right);
			}
			if (!currentLevel.isEmpty())
				zigzag.add(new ArrayList(currentLevel));
			currentLevel.clear();

			while (!leftToRight.isEmpty()) {
				TreeNode n = leftToRight.pop();
				currentLevel.add(n.val);
				if (n.right != null)
					rightToLeft.add(n.right);
				if (n.left != null)
					rightToLeft.add(n.left);
			}
			if (!currentLevel.isEmpty())
				zigzag.add(new ArrayList(currentLevel));
			currentLevel.clear();
		}
		return zigzag;
	}
}