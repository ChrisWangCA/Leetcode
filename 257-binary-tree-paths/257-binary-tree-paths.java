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
        List<Integer> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        traversal(root,path,res);
        return res;
    }
    private void traversal(TreeNode root,List<Integer> path,List<String> res){
        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<path.size()-1;i++){
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;
        }
        if(root.left!=null){
            traversal(root.left,path,res);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            traversal(root.right,path,res);
            path.remove(path.size()-1);
        }
    }
}