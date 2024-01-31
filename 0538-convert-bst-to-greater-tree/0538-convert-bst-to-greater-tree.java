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
    int res = 0;
    public TreeNode convertBST(TreeNode root) {
        return convert(root);
    }
    
    public TreeNode convert(TreeNode root){
        if(root == null) return null;
        root.right = convert(root.right);
        root.val += res;
        res = root.val;
        root.left = convert(root.left);
        return root;
    }
}