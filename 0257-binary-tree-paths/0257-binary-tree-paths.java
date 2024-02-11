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
    List<String> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        backtracing(root);
        return res;
    }
    public void backtracing(TreeNode root){
        list.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size();i++){
                if(i != list.size()-1){
                    sb.append(list.get(i)).append("->");
                }else{
                    sb.append(list.get(i));
                }
            }
            res.add(sb.toString());
        }
        if(root.left != null){
            backtracing(root.left);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            backtracing(root.right);
            list.remove(list.size()-1);
        }
    }
}