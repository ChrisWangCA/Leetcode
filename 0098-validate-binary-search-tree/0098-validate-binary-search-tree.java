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
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }
    public boolean isValid(TreeNode root){
        if(root == null) return true;
        boolean left = isValid(root.left);
        int cur = root.val;
        if(pre != null && cur <= pre.val){
            return false;
        }
        pre = root;
        boolean right = isValid(root.right);
        return left && right;
    }
}