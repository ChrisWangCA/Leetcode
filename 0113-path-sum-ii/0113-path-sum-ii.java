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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        pathFun(root,targetSum);
        return res;
    }
    
    public void pathFun(TreeNode root,int targetSum){
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if(root.left != null){
            pathFun(root.left,targetSum - root.val);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            pathFun(root.right,targetSum - root.val);
            path.remove(path.size()-1);
        }
    }
}