class Solution {
    public boolean checkValidString(String s) {
        if(s == null || s.length() < 1) return false;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i] == '('){
                stack.push(i);
            }else if(chs[i] == '*'){
                starStack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!stack.isEmpty() && !starStack.isEmpty()){
            int i = stack.pop();
            int j = starStack.pop();
            if(i > j) return false;
        }
        return stack.isEmpty();
    }
}