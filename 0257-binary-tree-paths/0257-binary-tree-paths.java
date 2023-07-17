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
        List<String> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recursion(root,list,path);
        return list;
    }
    public void recursion(TreeNode root,List<String> list,List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<path.size()-1;i++){
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            list.add(sb.toString());
            return;
        }
        if(root.left != null){
            recursion(root.left,list,path);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            recursion(root.right,list,path);
            path.remove(path.size()-1);
        }
    }
}