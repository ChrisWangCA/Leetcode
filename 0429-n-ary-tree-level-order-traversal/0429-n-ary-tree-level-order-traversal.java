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
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while(len-- > 0){
                Node temp = queue.poll();
                list.add(temp.val);
                if(temp.children != null){
                    for(Node child:temp.children){
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}