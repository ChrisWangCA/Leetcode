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
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
            isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }
}