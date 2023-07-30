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
    
    public TreeNode build(int[] pre, int pS,int pE, int[] in, int iS, int iE){
        if(pS == pE) return null;
        int rootVal = pre[pS];
        TreeNode root = new TreeNode(rootVal);
        int mid;
        for(mid = iS;mid < iE;mid++){
            if(in[mid] == rootVal) break;
        }
        int leftIS = iS;
        int leftIE = mid;
        int rightIS = mid+1;
        int rightIE = iE;
        
        int leftPS = pS + 1;
        int leftPE = pS + 1 + (mid - iS);
        int rightPS = leftPE;
        int rightPE = pE;
        
        root.left = build(pre, leftPS, leftPE,in, leftIS, leftIE);
        root.right = build(pre, rightPS, rightPE, in, rightIS,rightIE);
        return root;
    }
}