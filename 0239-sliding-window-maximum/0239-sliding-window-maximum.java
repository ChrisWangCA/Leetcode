class Solution {
    Deque<Integer> deque = new ArrayDeque<>();
    class MyQueue{
        void pop(int val){
            if(!deque.isEmpty() && val == deque.peek()){
                deque.poll();
            }
        }
        void add(int val){
            while(!deque.isEmpty() && val > deque.peekLast()){
                deque.removeLast();
            }
            deque.add(val);
        }
        int max(){
            return deque.peek();
        }
    }
    
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) return nums;
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int index = 0;
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