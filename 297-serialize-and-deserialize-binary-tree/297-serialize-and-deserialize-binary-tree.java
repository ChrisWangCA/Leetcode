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
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i!=arr.length;i++) queue.offer(arr[i]);
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue){
        String res = queue.poll();
        if(res.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(res));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));