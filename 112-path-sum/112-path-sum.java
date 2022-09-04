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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null) return targetSum == 0;
        if(root.left!=null){
            boolean left = hasPathSum(root.left,targetSum);
            if(left){
                return true;
            }
        }
        if(root.right!=null){
            boolean right = hasPathSum(root.right,targetSum);
            if(right){
                return true;
            }
        }
        return false;
    }
}