class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/")){
                stack.push(Integer.valueOf(s));
            }else{
                int n1 = stack.pop();
                int n2 = stack.pop();
                if(s.equals("+")){
                    stack.push(n1+n2);
                }else if(s.equals("-")){
                    stack.push(n2-n1);
                }else if(s.equals("*")){
                    stack.push(n2*n1);
                }else if(s.equals("/")){
                    stack.push(n2/n1);
                }
            }
        }
        return stack.pop();
    }
}