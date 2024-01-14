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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(getABS(root.left)-getABS(root.right)) <= 1 && 
            isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getABS(TreeNode root){
        if(root == null) return 0;
        return Math.max(getABS(root.left),getABS(root.right))+1;
    }
}