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
    int maxDepth = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        traversal(root,0);
        return res;
        
    }
    
    public void traversal(TreeNode root,int depth){
        if(root.left == null && root.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                res = root.val;
            }
        }
        if(root.left != null){
            depth++;
            traversal(root.left,depth);
            depth--;
        }
        if(root.right != null){
            depth++;
            traversal(root.right,depth);
            depth--;
        }
    }
}