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
        invertOrder(root);
        return root;
    }

    public void invertOrder(TreeNode root){
        if(root == null)
            return;

        invertOrder(root.right);
        invertOrder(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }
}
