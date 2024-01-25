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
    List<Integer> res = new ArrayList<>();
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        recursive(root);
        int[] r  = new int[res.size()];
        for(int i=0;i<res.size();i++){
            r[i] = res.get(i);
        }
        return r;
    }
    
    public void recursive(TreeNode root){
        if(root == null) return;
        recursive(root.left);
        int val = root.val;
        if(pre == null || val != pre.val){
            count = 1;
        }else{
            count ++;
        }
        if(count > maxCount){
            res.clear();
            maxCount = count;
            res.add(val);
        }else if(count == maxCount){
            res.add(val);
        }
        pre = root;
        recursive(root.right);
    }
}