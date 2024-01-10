class Solution {
    
    Deque<Integer> queue = new ArrayDeque<>();
    
    class MyQueue{
        
        public void push(int val){
            while(!queue.isEmpty() && val > queue.peekLast()){
                queue.pollLast();
            }
            queue.addLast(val);
        }
        
        public void pop(int val){
            if(!queue.isEmpty() && val == queue.peekFirst()){
                queue.pollFirst();
            }
        }
        
        public int getMax(){
            return queue.peekFirst();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int index = 0;
        MyQueue queue = new MyQueue();
        for(int i=0;i<k;i++){
            queue.push(nums[i]);
        }
        res[index++] = queue.getMax();
        for(int i=k;i<nums.length;i++){
            queue.pop(nums[i-k]);
            queue.push(nums[i]);
            res[index++] = queue.getMax();
        }
        return res;
    }
}