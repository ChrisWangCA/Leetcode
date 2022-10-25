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
    
    public class Info{
        int no;
        int yes;
        Info(int no,int yes){
            this.no = no;
            this.yes = yes;
        }
    }
    
    public int rob(TreeNode root) {
       Info res = process(root);
        return Math.max(res.no,res.yes);
    }
    
    public Info process(TreeNode root){
        if(root == null) return new Info(0,0);
        Info left = process(root.left);
        Info right = process(root.right);
        int planA = Math.max(left.no,left.yes) + Math.max(right.no,right.yes);
        int planB = root.val + left.no + right.no;
        return new Info(planA,planB);
    }
}