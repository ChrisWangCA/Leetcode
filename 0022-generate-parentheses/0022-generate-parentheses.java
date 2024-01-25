class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(n,n,"",res);
        return res;
    }
    
    public void recursive(int left,int right,String str, List<String> res){
        if(left < 0 || right < 0 || left > right) return;
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        recursive(left-1,right,str+"(",res);
        recursive(left,right-1,str+")",res);
    }
}