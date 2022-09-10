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
        return traversal(nums,0,nums.length);
    }
    private TreeNode traversal(int[] nums,int leftIndex,int rightIndex){
        if(rightIndex - leftIndex < 1) return null;
        if(rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
        int maxVal = nums[leftIndex];
        int maxIndex = leftIndex;
        for(int i=leftIndex+1;i<rightIndex;i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = traversal(nums,leftIndex,maxIndex);
        root.right = traversal(nums,maxIndex+1,rightIndex);
        return root;
    }
}