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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return postorder(root, subRoot);
    }

    public boolean postorder(TreeNode root, TreeNode subroot){
        if(root == null)
            return false;
        
        if(checkSubtree(root, subroot))
            return true;

        boolean leftFlag = postorder(root.left, subroot);
        boolean rightFlag = postorder(root.right, subroot);

        if(leftFlag || rightFlag)
            return true;

        return false;
    }

    public boolean checkSubtree(TreeNode root, TreeNode subroot){
        if(root == null && subroot == null)
            return true;
        
        if((root != null && subroot == null) || (root == null && subroot != null) || (root.val != subroot.val))
            return false;
        
        boolean leftFlag = checkSubtree(root.left, subroot.left);
        boolean rightFlag = checkSubtree(root.right, subroot.right);

        if(!(leftFlag && rightFlag))
            return false;
        
        return true;
    }
}
