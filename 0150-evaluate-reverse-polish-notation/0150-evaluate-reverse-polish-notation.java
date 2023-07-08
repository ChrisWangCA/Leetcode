class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str:tokens){
            if(str.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(str.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(str.equals("/")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 / t1);
            }else{
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }
}