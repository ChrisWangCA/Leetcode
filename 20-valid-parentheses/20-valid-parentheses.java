class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c:ch){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.peek() != c){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}