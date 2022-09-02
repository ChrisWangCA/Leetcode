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
        while (!queue.isEmpty()){
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollLast();
            if(left == null && right == null){
                continue;
            }
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            queue.offerFirst(left.left);
            queue.offerFirst(left.right);
            queue.offerLast(right.right);
            queue.offerLast(right.left);
        }
        return true;
    }
}