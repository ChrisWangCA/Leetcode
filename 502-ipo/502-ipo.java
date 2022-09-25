class Solution {
    class Node{
        int p;
        int c;
        Node(int p,int c){
            this.p = p;
            this.c = c;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Node[] nodes = new Node[profits.length];
        for(int i=0;i<profits.length;i++){
            nodes[i] = new Node(profits[i],capital[i]);
        }
        PriorityQueue<Node> small = new PriorityQueue<>((o1,o2)->o1.c-o2.c);
        PriorityQueue<Node> big = new PriorityQueue<>((o1,o2)->o2.p-o1.p);
        for(int i=0;i<nodes.length;i++){
            small.add(nodes[i]);
        }
        for(int i=0;i<k;i++){
            while(!small.isEmpty() && small.peek().c <= w){
                big.add(small.poll());
            }
            if(big.isEmpty()) return w;
            w += big.poll().p;
        }
        return w;
    }
}