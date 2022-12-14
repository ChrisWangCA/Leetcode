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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) return res;
        process(root,targetSum,res,path);
        return res;
    }
    public void process(TreeNode root,int target,List<List<Integer>> res,List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target - root.val == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if(root.left!=null){
            process(root.left,target-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            process(root.right,target-root.val,res,path);
            path.remove(path.size()-1);
        }
    }
}