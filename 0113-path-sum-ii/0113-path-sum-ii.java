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
        List<Integer> list = new ArrayList<>();
        if(root == null) return res;
        traversal(root,targetSum,res,list);
        return res;
    }
    
    public void traversal(TreeNode root, int targetSum,List<List<Integer>> res,
                          List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                res.add(new ArrayList<>(path));
            }
        }
        if(root.left != null){
            traversal(root.left,targetSum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            traversal(root.right,targetSum-root.val,res,path);
            path.remove(path.size()-1);
        }
    }
}