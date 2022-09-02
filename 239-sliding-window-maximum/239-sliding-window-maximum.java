class Solution {
    Deque<Integer> queue = new LinkedList<>();
    class MyQueue{
        void pop(int val){
            if(!queue.isEmpty() && val == queue.peek()){
                queue.poll();
            }
        }
        void push(int val){
            while(!queue.isEmpty() && val > queue.getLast()){
                queue.removeLast();
            }
            queue.add(val);
        }
        int max(){
            return queue.peek();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1){
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int index = 0;
        MyQueue queue = new MyQueue();
        for(int i=0;i<k;i++){
            queue.push(nums[i]);
        }
        res[index++] = queue.max();
        for(int i=k;i<nums.length;i++){
            queue.pop(nums[i-k]);
            queue.push(nums[i]);
            res[index++] = queue.max();
        }
        return res;
    }
}