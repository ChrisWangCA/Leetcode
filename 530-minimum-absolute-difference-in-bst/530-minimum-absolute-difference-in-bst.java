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
    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        getArray(root);
        int result = Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++){
            result = Math.min(result,res.get(i) - res.get(i-1));
        }
        return result;
    }
    private void getArray(TreeNode root){
        if(root == null) return;
        getArray(root.left);
        res.add(root.val);
        getArray(root.right);
    }
}