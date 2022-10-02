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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums,0,nums.length);
    }
    
    public TreeNode process(int[] nums,int left,int right){
        if(right-left<1) return null;
        if(right-left==1) return new TreeNode(nums[left]);
        int maxIndex=left;
        int maxVal=nums[left];
        for(int i=left;i<right;i++){
            if(maxVal<nums[i]){
                maxVal=nums[i];
                maxIndex=i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left=process(nums,left,maxIndex);
        root.right=process(nums,maxIndex+1,right);
        return root;
    }
}