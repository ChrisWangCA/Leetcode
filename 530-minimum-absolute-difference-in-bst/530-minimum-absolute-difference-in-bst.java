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
    int res = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        getMinimum(root);
        return res;
    }
    private void getMinimum(TreeNode root){
        if(root == null) return;
        getMinimum(root.left);
        if(pre!=null){
            res = Math.min(res,root.val - pre.val);
        }
        pre = root;
        getMinimum(root.right);
    }
}