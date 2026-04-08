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
        boolean[] flag = new boolean[1];
        checkSubtree(root, subRoot, flag);
        return flag[0];
    }

    public void checkSubtree(TreeNode root, TreeNode subroot, boolean[] flag){
        if(root == null)
            return;
        
        if(root.val == subroot.val){
            flag[0] = checkSimilar(root, subroot);
            if(flag[0] == true)
                return;
        }
        checkSubtree(root.left, subroot, flag);
        checkSubtree(root.right, subroot, flag);
    }

    public boolean checkSimilar(TreeNode root, TreeNode subroot){
        if(root == null && subroot == null)
            return true;
        
        if(root == null && subroot != null || root != null && subroot == null || root.val != subroot.val)
            return false;
        
        return checkSimilar(root.left, subroot.left) && checkSimilar(root.right, subroot.right);
    }
}
