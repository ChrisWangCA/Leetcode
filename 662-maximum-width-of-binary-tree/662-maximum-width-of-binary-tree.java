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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int max = 1;
        int next = 0;
        root.val = 1;
        if(root == null) return 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len > 0){
                TreeNode temp = queue.poll();
                len --;
                if(temp.left!=null){
                    temp.left.val = temp.val*2;
                    queue.offer(temp.left);
                    next++;
                }
                if(temp.right!=null){
                    temp.right.val = temp.val*2+1;
                    queue.offer(temp.right);
                    next++;
                }
                if(len == 0){
                    if(next!=0){
                        max = Math.max(max,queue.peekLast().val - queue.peekFirst().val +1);
                        next=0;
                    }
                }
            }
        }
        return max;
    }
}