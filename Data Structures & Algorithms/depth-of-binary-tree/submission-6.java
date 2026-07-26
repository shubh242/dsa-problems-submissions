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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return postorder(root, depth);
    }

    public int postorder(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }
        return Math.max(postorder(root.left, depth+1), postorder(root.right, depth+1));
    }
}
