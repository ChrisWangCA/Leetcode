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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newRoot = new TreeNode(val);
        if(root == null) return newRoot;
        if(root.val > val){
            insertIntoBST(root.left,val);
            if(root.left == null) root.left = newRoot;
        }else{
            insertIntoBST(root.right,val);
            if(root.right == null) root.right = newRoot;
        }
        return root;
    }
}