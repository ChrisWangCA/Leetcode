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
        return construct(nums,0,nums.length);
    }
    
    public TreeNode construct(int[] nums,int leftIndex,int rightIndex){
        if(rightIndex- leftIndex < 1) return null;
        if(rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
        int maxValue = nums[leftIndex];
        int maxIndex = leftIndex;
        for(int i=leftIndex+1;i<rightIndex;i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = construct(nums,leftIndex,maxIndex);
        root.right = construct(nums,maxIndex+1,rightIndex);
        return root;
    }
}