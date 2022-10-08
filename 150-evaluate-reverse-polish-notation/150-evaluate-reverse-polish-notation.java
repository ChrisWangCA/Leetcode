class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                stack.push(Integer.valueOf(s));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(s.equals("+")){
                    stack.push(num1+num2);
                }else if(s.equals("-")){
                    stack.push(num2-num1);
                }else if(s.equals("*")){
                    stack.push(num2*num1);
                }else if(s.equals("/")){
                    stack.push(num2/num1);
                }
            }
        }
        return stack.peek();
    }
}