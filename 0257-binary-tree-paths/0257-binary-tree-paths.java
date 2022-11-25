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
        if(root == null) return res;
        List<Integer> list = new ArrayList<>();
        process(root,list,res);
        return res;
    }
    
    public void process(TreeNode root,List<Integer> list,List<String> res){
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
            process(root.left,list,res);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            process(root.right,list,res);
            list.remove(list.size()-1);
        }
    }
}