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
    public boolean isValidBST(TreeNode root) {
        return checkWithDFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkWithDFS(TreeNode root, int left, int right){
        if(root == null)
            return true;

        if(!(right > root.val && left < root.val)){
            return false;
        }

        return (checkWithDFS(root.left, left, root.val) && checkWithDFS(root.right, root.val, right));
    }
}
