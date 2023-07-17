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
          int maxDepth = Integer.MIN_VALUE;
        int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root,0);
        return res;
    }
    public void traversal(TreeNode root,int depth){
        if(root.left == null && root.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                res = root.val;
            }
            return;
        }
        if(root.left != null){
            depth ++;
            traversal(root.left,depth);
            depth--;
        }
        if(root.right != null){
            depth ++;
            traversal(root.right,depth);
            depth--;
        }
        return;
    }
}