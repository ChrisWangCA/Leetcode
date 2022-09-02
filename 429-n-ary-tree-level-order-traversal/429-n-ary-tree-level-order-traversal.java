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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while(len > 0){
                Node node = queue.poll();
                list.add(node.val);
                List<Node> children = node.children;
                for(Node child:children){
                    if(child!=null){
                        queue.offer(child);
                    }
                }
                len--;
            }
            res.add(list);
        }
        return res;
    }
}