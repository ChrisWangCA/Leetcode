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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.right != null && root.left == null){
                return root.right;
            }else{
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }
}