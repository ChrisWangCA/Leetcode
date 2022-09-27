class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> bigHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>();
        bigHeap = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
    }
    
    public void addNum(int num) {
        if(smallHeap.isEmpty() || num >= smallHeap.peek()){
            smallHeap.add(num);
            if(smallHeap.size() - bigHeap.size() > 1){
                bigHeap.add(smallHeap.poll());
            }
        }else{
            bigHeap.add(num);
            if(bigHeap.size() - smallHeap.size() > 0){
                smallHeap.add(bigHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        return smallHeap.size() > bigHeap.size() ? smallHeap.peek() : 
        (smallHeap.peek() + bigHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */