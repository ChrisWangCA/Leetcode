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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    
    public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder, int inStart,int inEnd){
        if(preStart == preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int mid;
        for(mid = inStart;mid < inEnd; mid++){
            if(inorder[mid] == rootVal) break;
        }
        int leftInStart = inStart;
        int leftInEnd = mid;
        int rightInStart = mid+1;
        int rightInEnd = inEnd;
        
        int leftPreStart = preStart+1;
        int leftPreEnd = preStart + 1 + (mid - inStart);
        int rightPreStart = leftPreEnd;
        int rightPreEnd = preEnd;
        
        root.left = build(preorder, leftPreStart, leftPreEnd, inorder, leftInStart,leftInEnd);
        root.right = build(preorder,rightPreStart,rightPreEnd,inorder, rightInStart, rightInEnd);
        return root;
    }
}