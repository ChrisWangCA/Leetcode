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
    int min = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        traversal(root);
        return min;
    }
    private void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        if(pre != null){
            min = Math.min(min,root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}