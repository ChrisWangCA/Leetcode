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
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root.left);
        queue.offerLast(root.right);
        while(!queue.isEmpty()){
            TreeNode temp1 = queue.pollFirst();
            TreeNode temp2 = queue.pollLast();
            if(temp1 == null && temp2 == null) continue;
            if(temp1 == null || temp2 == null || temp1.val != temp2.val) return false;
            queue.offerFirst(temp1.left);
            queue.offerFirst(temp1.right);
            queue.offerLast(temp2.right);
            queue.offerLast(temp2.left);
        }
        return true;
    }
}