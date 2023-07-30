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
        return build(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    public TreeNode build(int[] in, int inStart,int inEnd, int[] post,int postStart,int postEnd){
        if(postStart == postEnd) return null;
        int rootVal = post[postEnd-1];
        TreeNode root = new TreeNode(rootVal);
        int mid;
        for(mid = inStart;mid<inEnd;mid++){
            if(in[mid] == rootVal) break;
        }
        int leftInStart = inStart;
        int leftInEnd = mid;
        int rightInStart = mid+1;
        int rightInEnd = inEnd;
        
        int leftPostStart = postStart;
        int leftPostEnd = postStart + (mid - inStart);
        int rightPostStart = leftPostEnd;
        int rightPostEnd = postEnd-1;
        
        root.left = build(in,leftInStart,leftInEnd,post,leftPostStart,leftPostEnd);
        root.right = build(in,rightInStart,rightInEnd,post,rightPostStart,rightPostEnd);
        return root;
    }
}