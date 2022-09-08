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
    ArrayList<Integer> list;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        traversal(root);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
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