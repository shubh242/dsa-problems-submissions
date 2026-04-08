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
    int last = Integer.MIN_VALUE;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        
        for(List<Integer> arr: levelOrder(root)){
            rightSide.add(arr.get(arr.size()-1));
        }

        return rightSide;
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null)
            return new ArrayList<>();
            
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> subres = new ArrayList<>();
            int j = q.size()-1;
            while(j >= 0){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
                subres.add(curr.val);
                j--;
            }
            if(subres.size() > 0){
                result.add(subres);
            }
        }
        return result;
    }
}
