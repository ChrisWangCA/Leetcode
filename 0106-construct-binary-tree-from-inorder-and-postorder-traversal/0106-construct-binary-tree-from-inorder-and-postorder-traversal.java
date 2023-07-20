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
        if(inorder.length==0 || postorder.length==0) return null;
        return build(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                         int[] postorder,int postStart,int postEnd){
        if(postStart == postEnd) return null;
        int rootValue = postorder[postEnd-1];
        TreeNode root = new TreeNode(rootValue);
        int mid;
        for(mid = inStart;mid<inEnd;mid++){
            if(inorder[mid] == rootValue){
                break;
            }
        }
        int leftInStart = inStart;
        int leftInEnd = mid;
        int rightInStart = mid+1;
        int rightInEnd = inEnd;
        
        int leftPostStart = postStart;
        int leftPostEnd = postStart + (mid - inStart);
        int rightPostStart = leftPostEnd;
        int rightPostEnd = postEnd-1;
        
        root.left = build(inorder,leftInStart, leftInEnd,postorder,leftPostStart,leftPostEnd);
        root.right = build(inorder,rightInStart,rightInEnd,postorder,rightPostStart,rightPostEnd);
        return root;
    }
}