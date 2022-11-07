class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                stack.push(Integer.valueOf(s));
            }else{
                int i = stack.pop();
                int j = stack.pop();
                if(s.equals("+")){
                    stack.push(i+j);
                }else if(s.equals("-")){
                    stack.push(j-i);
                }else if(s.equals("*")){
                    stack.push(j*i);
                }else if(s.equals("/")){
                    stack.push(j/i);
                }
            }
        }
        return stack.pop();
    }
}