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
    long min = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return compare(root);
    }
    private boolean compare(TreeNode root){
        if(root == null) return true;
        boolean left = compare(root.left);
        if(root.val <= min) return false;
        min = root.val;
        boolean right = compare(root.right);
        return left && right;
    }
}