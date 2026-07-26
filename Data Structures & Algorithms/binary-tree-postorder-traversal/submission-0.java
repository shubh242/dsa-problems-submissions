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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderResult = new ArrayList<>();
        postorder(root, postorderResult);
        return postorderResult;
    }

    public void postorder(TreeNode root, List<Integer> postorderResult) {
        if(root == null) {
            return;
        }

        postorder(root.left, postorderResult);
        postorder(root.right, postorderResult);
        postorderResult.add(root.val);
    }
}