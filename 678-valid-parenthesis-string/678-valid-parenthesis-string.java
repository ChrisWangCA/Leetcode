class Solution {
    public boolean checkValidString(String s) {
        if(s == null) return false;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                left.push(i);
            }else if(c == '*'){
                star.push(i);
            }else{
                if(!left.isEmpty()){
                    left.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            int i = left.pop();
            int j = star.pop();
            if(i > j) return false;
        }
        return left.isEmpty();
    }
}