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
        String[] arr = data.split("_");
        Deque<String> deque = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            deque.add(arr[i]);
        }
        return deserialize(deque);
    }
    
    public TreeNode deserialize(Deque<String> deque){
        String res = deque.poll();
        if(res.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(res));
        root.left = deserialize(deque);
        root.right = deserialize(deque);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));