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
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        recursive(root,path);
        return res;
    }
    
    public void recursive(TreeNode root,List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<path.size();i++){
                if(i != path.size()-1){
                    sb.append(path.get(i)).append("->");
                }else{
                    sb.append(path.get(i));
                }
            }
            res.add(sb.toString());
        }
        if(root.left != null){
            recursive(root.left,path);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            recursive(root.right,path);
            path.remove(path.size()-1);
        }
    }
}