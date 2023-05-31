class MyStack {
    
    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.addLast(x);
    }
    
    public int pop() {
        int len = queue.size();
        len--;
        while(len-- > 0){
            queue.addLast(queue.peekFirst());
            queue.pollFirst();
        }
        int res = queue.pollFirst();
        return res;
    }
    
    public int top() {
        return queue.peekLast();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */