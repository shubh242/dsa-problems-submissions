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
        List<List<Integer>> result = new ArrayList<>();
        q.add(root); // 1
        while(!q.isEmpty()){
            int size = q.size(); // 2 
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode child = q.poll(); // 1, 2, 3
                if(child.left != null) // 4,5,6
                    q.add(child.left);
                if(child.right != null) // 4,5,6,7
                    q.add(child.right);
                
                temp.add(child.val); // [1], [2,3], []
            }
            if(temp.size() > 0)
                result.add(temp);
        }
        return result;
    }
}
