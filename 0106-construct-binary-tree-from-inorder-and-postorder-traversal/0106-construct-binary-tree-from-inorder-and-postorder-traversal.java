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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        return func(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    
    public TreeNode func(int[] inorder,int inorderStart, int inorderEnd, int[] postorder, int postStart, int postEnd){
        if(postStart == postEnd) return null;
        int rootValue = postorder[postEnd-1];
        TreeNode root = new TreeNode(rootValue);
        int i;
        for(i=inorderStart;i<inorderEnd;i++){
            if(inorder[i] == rootValue){
                break;
            }
        }
        int leftInorderStart = inorderStart;
        int leftInorderEnd = i;
        int rightInorderStart = i+1;
        int rightInorderEnd = inorderEnd;
        
        int leftPostStart = postStart;
        int leftPostEnd = postStart + (i - inorderStart);
        int rightPostStart = leftPostEnd;
        int rightPostEnd = postEnd -1;
        
        root.left = func(inorder,leftInorderStart,leftInorderEnd,postorder,
                         leftPostStart,leftPostEnd);
        root.right = func(inorder,rightInorderStart,rightInorderEnd,postorder,
                         rightPostStart,rightPostEnd);
        return root;
    }
}