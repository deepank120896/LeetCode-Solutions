// 106. Construct Binary Tree from Inorder and Postorder Traversal

// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// For example, given
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]

// Return the following binary tree:

    // 3
   // / \
  // 9  20
    // /  \
   // 15   7
   
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0 || postorder == null || postorder.length==0)
            return null;
        
        int ip = inorder.length-1;
        int pp = postorder.length-1;
        
        TreeNode previous = null;
        Stack<TreeNode> s = new Stack();
        TreeNode root = new TreeNode(postorder[pp--]);
        s.push(root);
        
        while(pp >= 0){
            while(!s.isEmpty() && inorder[ip]==s.peek().val)
            {
                previous = s.pop();
                ip--;
            }
            TreeNode current = new TreeNode(postorder[pp]);
            if(previous!=null)
                previous.left = current;
            else
            {
                TreeNode top = s.peek();
                top.right = current;
            }
            pp--;
            s.push(current);
            previous=null;
        }
        return root;
    }
}