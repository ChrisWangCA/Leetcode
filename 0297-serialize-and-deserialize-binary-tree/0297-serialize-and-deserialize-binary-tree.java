/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#_";
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split("_");
        Deque<String> deque = new LinkedList<>();
        for(String s:str){
            deque.offer(s);
        }
        return deserialize(deque);
    }
    
    public TreeNode deserialize(Deque<String> deque){
        String temp = deque.poll();
        if(temp.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(temp));
        root.left = deserialize(deque);
        root.right = deserialize(deque);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));