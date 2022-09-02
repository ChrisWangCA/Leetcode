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
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        recursion(root,0);
        return res;
    }
    private void recursion(TreeNode root, int deep){
        if(root == null){
            return;
        }
        deep++;
        if(res.size() < deep){
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(deep - 1).add(root.val);
        recursion(root.left,deep);
        recursion(root.right,deep);
    }
}