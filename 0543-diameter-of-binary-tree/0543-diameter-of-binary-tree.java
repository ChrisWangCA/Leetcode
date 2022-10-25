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
    
    class Info{
        int maxDistance;
        int height;
        Info(int m,int h){
            this.maxDistance = m;
            this.height = h;
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return process(root).maxDistance;
    }
    
    public Info process(TreeNode root){
        if(root == null) return new Info(0,0);
        Info left = process(root.left);
        Info right = process(root.right);
        int p1 = left.maxDistance;
        int p2 = right.maxDistance;
        int p3 = left.height + right.height;
        int maxDistance = Math.max(p3,Math.max(p1,p2));
        int height = Math.max(left.height,right.height)+1;
        return new Info(maxDistance,height);
    }
}