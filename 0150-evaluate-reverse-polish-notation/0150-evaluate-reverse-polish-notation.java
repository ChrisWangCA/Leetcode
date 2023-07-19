class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str:tokens){
            if(!str.equals("+")&&!str.equals("-")&&!str.equals("*")&&!str.equals("/")){
                stack.push(Integer.valueOf(str));
            }else{
                int n1 = stack.pop();
                int n2 = stack.pop();
                if(str.equals("+")){
                    stack.push(n1+n2);
                }else if(str.equals("-")){
                    stack.push(n2-n1);
                }else if(str.equals("*")){
                    stack.push(n2*n1);
                }else if(str.equals("/")){
                    stack.push(n2/n1);
                }
            }
        }
        return stack.pop();
    }
}