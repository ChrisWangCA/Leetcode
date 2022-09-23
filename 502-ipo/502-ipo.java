class Solution {
    public class Node{
        int p;
        int c;
        public Node(int p,int c){
            this.p=p;
            this.c=c;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Node[] nodes = new Node[profits.length];
        for(int i=0;i<profits.length;i++){
            nodes[i] = new Node(profits[i],capital[i]);
        }
        PriorityQueue<Node> min = new PriorityQueue<>((o1,o2)->o1.c -o2.c);
        PriorityQueue<Node> max = new PriorityQueue<>((o1,o2)->o2.p -o1.p);
        for(int i=0;i<nodes.length;i++){
            min.add(nodes[i]);
        }
        for(int i=0;i<k;i++){
            while(!min.isEmpty() && min.peek().c <= w){
                max.add(min.poll());
            }
            if(max.isEmpty()) return w;
            w += max.poll().p;
        }
        return w;
    }
}