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
    List<Integer> inorderResult = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return inorderResult;
    }

    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }


        TreeNode left = root.left != null ? root.left : null;
        // if(left != null)
        //     inorderResult.add(left.val);
        inorder(left);
        if(root != null)
            inorderResult.add(root.val);
        TreeNode right = root.right != null ? root.right : null;
        inorder(right);
        // if(right != null)
        //     inorderResult.add(right.val);
    }
}