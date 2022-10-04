class Solution {
    public boolean checkValidString(String s) {
        if(s == null) return false;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == '*'){
                star.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop(); 
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!stack.isEmpty() && !star.isEmpty()){
            int left = stack.pop();
            int st = star.pop();
            if(left > st) return false;
        }
        return stack.isEmpty();
    }
}