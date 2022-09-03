/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        int level = 0;
        if (root == null){
            return level;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i=0;i<len;i++){
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child:children){
                    if (child!=null){
                        queue.offer(child);
                    }
                }
            }
            level++;
        }
        return level;
    }
}