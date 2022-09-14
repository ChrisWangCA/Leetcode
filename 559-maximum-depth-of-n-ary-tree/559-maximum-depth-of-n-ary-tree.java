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
        int depth = 0;
        if(root == null) return depth;
        if(root.children!=null){
            for(Node child:root.children){
                depth = Math.max(depth,maxDepth(child));
            }
        }
        return depth+1;
    }
}