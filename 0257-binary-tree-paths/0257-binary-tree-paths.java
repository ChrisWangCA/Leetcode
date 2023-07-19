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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(root,res,list);
        return res;
    }
    public void recursion(TreeNode root,List<String> res,List<Integer> list){
        list.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size()-1;i++){
                sb.append(list.get(i)).append("->");
            }
            sb.append(list.get(list.size()-1));
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            recursion(root.left,res,list);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            recursion(root.right,res,list);
            list.remove(list.size()-1);
        }
    }
}