class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || c != stack.peek()){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}