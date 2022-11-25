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
        return Math.abs(process(root.left) - process(root.right)) <= 1 &&
            isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int process(TreeNode root){
        if(root == null) return 0;
        return Math.max(process(root.left),process(root.right)) + 1;
    }
}