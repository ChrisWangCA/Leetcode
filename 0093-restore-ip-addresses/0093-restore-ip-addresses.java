class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracing(sb,0,0);
        return res;
    }
    public void backtracing(StringBuilder s,int startIndex, int sumDot){
        if(sumDot == 3){
            if(isValid(s,startIndex,s.length()-1)){
                res.add(s.toString());
                return;
            }
        }
        for(int i=startIndex;i<s.length();i++){
            if(isValid(s,startIndex,i)){
                s.insert(i+1,".");
                backtracing(s,i+2,sumDot+1);
                s.deleteCharAt(i+1);
            }else{
                break;
            }
        }
    }
    public boolean isValid(StringBuilder s,int start,int end){
        int sum = 0;
        if(start > end) return false;
        if(s.charAt(start) == '0' && start != end) return false;
        for(int i=start;i<=end;i++){
            int digit = s.charAt(i)-'0';
            sum = sum * 10 + digit;
            if(sum > 255) return false;
        }
        return true;
    }
}