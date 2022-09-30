class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int cur = n - k + 1;
        double[] res = new double[cur];
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2)->o2.compareTo(o1));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            right.add(nums[i]);
        }
        for(int i=0;i<k/2;i++){
            left.add(right.poll());
        }
        res[0] = getMid(left,right);
        for(int i=k;i<n;i++){
            int add = nums[i];
            int del = nums[i-k];
            if(add >= right.peek()){
                right.add(add);
            }else{
                left.add(add);
            }
            if(del >= right.peek()){
                right.remove(del);
            }else{
                left.remove(del);
            }
            adjust(left,right);
            res[i-k+1] = getMid(left,right);
        }
        return res;
    }
    
    public void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right){
        while(left.size() > right.size()){
            right.add(left.poll());
        }
        while(right.size() - left.size() > 1){
            left.add(right.poll());
        }
    }
    
    public double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right){
        if(left.size() == right.size()){
            return (left.peek() / 2.0) + (right.peek() / 2.0);
        }else{
            return right.peek() * 1.0;
        }
    }
}