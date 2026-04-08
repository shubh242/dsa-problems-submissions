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
    int result = Integer.MAX_VALUE;
    int idx = 0;
    public int kthSmallest(TreeNode root, int k) {
        idx = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root){
        if(root == null)
            return;

        dfs(root.left);
        idx -= 1;
        if(idx == 0){
            result = root.val;
            return;
        }
        dfs(root.right);
    } 
}
