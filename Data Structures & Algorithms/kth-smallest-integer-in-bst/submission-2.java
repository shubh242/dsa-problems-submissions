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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[]{Integer.MAX_VALUE};
        int[] idx = new int[]{k};
        dfs(root, idx, result);
        return result[0];
    }

    public void dfs(TreeNode root, int[] k, int[] result){
        if(root == null)
            return;
        
        dfs(root.left, k, result);
        k[0]-=1;
        if(k[0] == 0){
            result[0] = Math.min(result[0], root.val);
            return;
        }
        dfs(root.right, k, result);
    }
}
