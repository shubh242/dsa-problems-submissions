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
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        postorder(root);
        return result;
    }

    public int postorder(TreeNode root){
        if(root == null)
            return 0;
        int left = postorder(root.left);
        int right = postorder(root.right);
        result = Math.max(result, (left+right));
        return 1 + Math.max(left, right);
    }
}
