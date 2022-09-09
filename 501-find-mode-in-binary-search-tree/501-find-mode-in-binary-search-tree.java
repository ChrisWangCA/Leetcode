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
    ArrayList<Integer> list = new ArrayList<>();
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        int value = root.val;
        if(pre == null || value != pre.val){
            count = 1;
        }else{
            count ++;
        }
        if(count > maxCount){
            list.clear();
            list.add(value);
            maxCount = count;
        }else if(count == maxCount){
            list.add(value);
        }
        pre = root;
        traversal(root.right);
    }
}