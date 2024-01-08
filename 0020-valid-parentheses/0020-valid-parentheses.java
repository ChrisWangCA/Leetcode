class Solution {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(char c:chs){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.peek()){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}