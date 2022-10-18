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
        process(root,res,list,targetSum);
        return res;
    }
    
    public void process(TreeNode root,List<List<Integer>> res,List<Integer> list,int target){
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(target - root.val == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(root.left != null){
            process(root.left,res,list,target-root.val);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            process(root.right,res,list,target-root.val);
            list.remove(list.size()-1);
        }
    }
}