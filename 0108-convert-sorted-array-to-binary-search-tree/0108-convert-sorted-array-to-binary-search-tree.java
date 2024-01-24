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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums,0,nums.length-1);
    }
    
    public TreeNode sorted(int[] res,int left,int right){
        if(left > right) return null;
        int mid = left + ((right-left)/2);
        TreeNode root = new TreeNode(res[mid]);
        root.left = sorted(res,left,mid-1);
        root.right = sorted(res,mid+1,right);
        return root;
    }
}