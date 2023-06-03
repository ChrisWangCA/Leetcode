class Solution {
    
    class Info{
        int p;
        int c;
        public Info(int p,int c){
            this.p = p;
            this.c = c;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Info[] info = new Info[profits.length];
        for(int i=0;i<profits.length;i++){
            info[i] = new Info(profits[i],capital[i]);
        }
        PriorityQueue<Info> small = new PriorityQueue<>((o1,o2)->o1.c-o2.c);
        PriorityQueue<Info> big = new PriorityQueue<>((o1,o2)->o2.p-o1.p);
        for(int i=0;i<profits.length;i++){
            small.offer(info[i]);
        }
        for(int i=0;i<k;i++){
            while(!small.isEmpty() && small.peek().c <= w){
                big.offer(small.poll());
            }
            if(big.isEmpty()){
                return w;
            }
            w += big.poll().p;
        }
        return w;
    }
}