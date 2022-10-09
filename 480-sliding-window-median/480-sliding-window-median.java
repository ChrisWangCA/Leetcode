class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int n = nums.length - k + 1;
        double[] res = new double[n];
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            smallHeap.add(nums[i]);
        }
        for(int i=0;i<k/2;i++){
            bigHeap.add(smallHeap.poll());
        }
        res[0] = getMid(bigHeap,smallHeap);
        for(int i=k;i<size;i++){
            int add = nums[i];
            int del = nums[i-k];
            if(add >= smallHeap.peek()){
                smallHeap.add(add);
            }else{
                bigHeap.add(add);
            }
            if(del >= smallHeap.peek()){
                smallHeap.remove(del);
            }else{
                bigHeap.remove(del);
            }
            adjust(bigHeap,smallHeap);
            res[i-k+1] = getMid(bigHeap,smallHeap);
        }
        return res;
    }
    
    public void adjust(PriorityQueue<Integer> bigHeap,PriorityQueue<Integer> smallHeap){
        while(bigHeap.size() > smallHeap.size()){
            smallHeap.add(bigHeap.poll());
        }
        while(smallHeap.size() - bigHeap.size() > 1){
            bigHeap.add(smallHeap.poll());
        }
    }
    
    public double getMid(PriorityQueue<Integer> bigHeap,PriorityQueue<Integer> smallHeap){
        if(bigHeap.size() == smallHeap.size()){
            return (bigHeap.peek() / 2.0) + (smallHeap.peek() / 2.0);
        }else{
            return smallHeap.peek() * 1.0;
        }
    }
}