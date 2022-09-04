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
        recursion(root,targetSum,res,list);
        return res;
    }
    private void recursion(TreeNode root,int target,List<List<Integer>> res,List<Integer> list){
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(target - root.val == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(root.left != null){
            recursion(root.left,target - root.val,res,list);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            recursion(root.right,target - root.val,res,list);
            list.remove(list.size()-1);
        }
    }
}