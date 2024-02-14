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
        return recursive(nums,0,nums.length);
    }
    
    public TreeNode recursive(int[] nums,int left,int right){
        if(right - left < 1) return null;
        if(right - left == 0) return new TreeNode(nums[left]);
        int maxValue = nums[left];
        int maxIndex = left;
        for(int i=left+1;i<right;i++){
            if(maxValue < nums[i]){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = recursive(nums,left,maxIndex);
        root.right = recursive(nums,maxIndex+1,right);
        return root;
    }
}