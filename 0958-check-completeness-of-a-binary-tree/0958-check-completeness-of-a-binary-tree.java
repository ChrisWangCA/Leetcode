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
    public boolean isCompleteTree(TreeNode root) {
        boolean flag = false;
        if(root == null) return flag;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(flag && !(temp.left== null && temp.right==null) || (temp.left==null && temp.right!=null)) return false;
            if(temp.left != null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
            if(temp.left == null || temp.right == null) flag = true;
        }
        return true;
    }
}