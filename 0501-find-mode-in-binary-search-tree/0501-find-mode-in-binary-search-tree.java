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
    int maxCount = 0;
    int count = 0;
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        find(root);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void find(TreeNode root){
        if(root == null) return;
        find(root.left);
        int val = root.val;
        if(pre != null && val != pre.val){
            count = 1;
        }else{
            count ++;
        }
        if(count > maxCount){
            list.clear();
            maxCount = count;
            list.add(val);
        }else if(count == maxCount){
            list.add(val);
        }
        pre = root;
        find(root.right);
    }
}