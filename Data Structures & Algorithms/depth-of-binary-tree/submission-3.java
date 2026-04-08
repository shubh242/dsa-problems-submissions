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
        int[] depth = new int[1];
        return dfs(root, depth);
    }

    public int dfs(TreeNode root, int[] depth){
        if(root == null)
            return 0;

        int left = dfs(root.left, depth);
        int right = dfs(root.right, depth);
        depth[0] = Math.max(left, right);
        return 1 + Math.max(left, right);
    }
}
