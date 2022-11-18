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
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        process(root);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public void process(TreeNode root){
        if(root == null) return;
        process(root.left);
        int res = root.val;
        if(pre == null || res != pre.val){
            count = 1;
        }else{
            count++;
        }
        if(count > maxCount){
            list.clear();
            list.add(res);
            maxCount = count;
        }else if(count == maxCount){
            list.add(res);
        }
        pre = root;
        process(root.right);
    }
    
}