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
    
    public TreeNode process(int[] nums,int leftIndex,int rightIndex){
        if(rightIndex - leftIndex < 1) return null;
        if(rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
        int maxValue = nums[leftIndex];
        int maxIndex = leftIndex;
        for(int i=leftIndex;i<rightIndex;i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = process(nums,leftIndex,maxIndex);
        root.right = process(nums,maxIndex+1,rightIndex);
        return root;
    }
}