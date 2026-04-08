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
    int counter = 0;

    public int goodNodes(TreeNode root) {
        int MAX_VAL = Integer.MIN_VALUE;
        preorder(root, MAX_VAL);
        return counter;
    }

    public void preorder(TreeNode root, int MAX_VAL){
        if(root == null){
            return;
        }

        if(root.val >= MAX_VAL){
            MAX_VAL = root.val;
            counter++;
        }

        preorder(root.left, MAX_VAL);
        preorder(root.right, MAX_VAL);
    }
}
