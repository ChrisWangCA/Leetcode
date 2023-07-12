class Solution {
    
    Deque<Integer> queue = new ArrayDeque<>();
    
    class MyQueue{
        void pop(int val){
            if(!queue.isEmpty() && val == queue.peek()){
                queue.poll();
            }
        }
        
        void add(int val){
            while(!queue.isEmpty() && val > queue.peekLast()){
                queue.removeLast();
            }
            queue.add(val);
        }
        
        int max(){
            return queue.peek();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int index = 0;
        int len = nums.length-k+1;
        int[] res = new int[len];
        MyQueue queue = new MyQueue();
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        res[index++] = queue.max();
        for(int i=k;i<nums.length;i++){
            queue.pop(nums[i-k]);
            queue.add(nums[i]);
            res[index++] = queue.max();
        }
        return res;
    }
}