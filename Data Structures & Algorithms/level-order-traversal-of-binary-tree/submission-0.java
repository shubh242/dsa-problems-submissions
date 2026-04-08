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

        Queue<List<TreeNode>> q = new LinkedList<>();
        List<TreeNode> f = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        f.add(root);
        q.offer(f);

        while(!q.isEmpty()){
            List<TreeNode> parent = q.poll();
            List<TreeNode> children = new ArrayList<>();
            List<Integer> subres = new ArrayList<>();
            int i = 0;
            while(!parent.isEmpty()){
                if(parent.get(i).left != null){
                    children.add(parent.get(i).left);
                }

                if(parent.get(i).right != null){
                    children.add(parent.get(i).right);
                }
                subres.add(parent.get(i).val);
                parent.remove(i);
            }
            if(children.size() > 0)
                q.offer(children);
            res.add(subres);
        }
        return res;
    }
}
