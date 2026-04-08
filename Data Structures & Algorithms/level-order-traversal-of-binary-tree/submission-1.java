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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> subres = new ArrayList<>();
            int i = q.size()-1;
            while(i >= 0){
                TreeNode parent = q.poll();
                if(parent.left != null){
                    q.add(parent.left);
                }

                if(parent.right != null){
                    q.add(parent.right);
                }
                subres.add(parent.val);
                i--;
            }
            if(subres.size() > 0)
                res.add(subres);
        }
        return res;
    }
}
