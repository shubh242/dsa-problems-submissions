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
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        
        reverse(root);
        TreeNode left = root.left != null ? root.left : null;
        dfs(left);
        TreeNode right = root.right != null ? root.right : null;
        dfs(right);
    }

    public void reverse(TreeNode root) {
        if(root != null){
            TreeNode left = (root != null) ? root.left : null;
            root.left = (root.right != null) ? root.right : null;
            root.right = left;
        }
    }
}
