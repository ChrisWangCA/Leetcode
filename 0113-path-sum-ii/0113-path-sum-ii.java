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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        recursive(root,targetSum);
        return res;
    }
    
    public void recursive(TreeNode root,int target){
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target - root.val == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if(root.left != null){
            recursive(root.left,target - root.val);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            recursive(root.right,target - root.val);
            path.remove(path.size()-1);
        }
    }
}