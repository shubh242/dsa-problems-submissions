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
    int idx = 0;
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1,2,3,4
        // 2=0,1=1,3=2,4=3
        // 1->
        for(int i = 0; i < inorder.length; i++)
            indexMap.put(inorder[i], i);
        
        return dfs(preorder, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int l, int r){
        if(l > r)
            return null;

        TreeNode root = new TreeNode(preorder[idx]);
        int mid = indexMap.get(preorder[idx]);
        idx++;
        root.left = dfs(preorder, l, mid-1);
        root.right = dfs(preorder, mid+1, r);
        return root;
    }
}
