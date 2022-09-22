class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((o1,o2)-> o2.compareTo(o1));        
    }

    
    public void addNum(int num) {
        if(minHeap.isEmpty() || num >= minHeap.peek()){
            minHeap.add(num);
            if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.add(minHeap.poll());
            }
        }else{
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() > 0){
                minHeap.add(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */