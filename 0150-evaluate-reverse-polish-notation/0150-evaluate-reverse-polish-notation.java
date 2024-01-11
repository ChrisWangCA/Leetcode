class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            switch(s){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int n3 = stack.pop();
                    int n4 = stack.pop();
                    stack.push(n4-n3);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n2/n1);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}