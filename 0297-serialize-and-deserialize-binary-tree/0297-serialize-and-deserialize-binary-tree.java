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
        String str = root.val + "_";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split("_");
        Deque<String> queue = new ArrayDeque<>();
        for(int i=0;i<str.length;i++){
            queue.offer(str[i]);
        }
        return deserialize(queue);
    }
    
    public TreeNode deserialize(Deque<String> queue){
        String str = queue.poll();
        if(str.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));