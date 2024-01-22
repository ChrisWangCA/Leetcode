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
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        find(root);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public void find(TreeNode root){
        if(root == null) return;
        find(root.left);
        int cur = root.val;
        if(pre == null || cur != pre.val){
            count=1;
        }else{
            count++;
        }
        if(count > maxCount){
            list.clear();
            maxCount = count;
            list.add(cur);
        }else if(count == maxCount){
            list.add(cur);
        }
        pre = root;
        find(root.right);
    }
}