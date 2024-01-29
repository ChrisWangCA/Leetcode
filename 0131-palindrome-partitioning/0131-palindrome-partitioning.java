class Solution {
    
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracing(s,0);
        return res;
    }
    public void backtracing(String s,int startIndex){
        if(startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isValid(s,startIndex,i)){
                String str = s.substring(startIndex,i+1);
                path.add(str);
            }else{
                continue;
            }
            backtracing(s,i+1);
            path.remove(path.size()-1);
        }
    }
    public boolean isValid(String s,int start,int end){
        for(int i=start;i<=end;i++,end--){
            if(s.charAt(i) != s.charAt(end)) return false;
        }
        return true;
    }
}