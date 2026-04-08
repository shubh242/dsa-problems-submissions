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
    public boolean isBalanced(TreeNode root) {
        int res = postorder(root);
        return res == -1 ? false: true;
    }

    public int postorder(TreeNode root){
        if(root == null)
            return 0;
        
        int left = postorder(root.left);
        int right = postorder(root.right);

        if(left == -1 || right == -1)
            return -1;

        if(!(Math.abs(left-right) <= 1))
            return -1;

        return 1+Math.max(left, right);
    }
}
