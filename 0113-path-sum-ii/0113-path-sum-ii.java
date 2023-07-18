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
        if(root == null) return res;
        List<Integer> path = new ArrayList<>();
        addPath(root,targetSum,res,path);
        return res;
    }
    
    public void addPath(TreeNode root,int target, List<List<Integer>> res,List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target - root.val == 0){
                res.add(new ArrayList<>(path));
            }
        }
        if(root.left != null){
            addPath(root.left,target-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            addPath(root.right,target-root.val,res,path);
            path.remove(path.size()-1);
        }
    }
}