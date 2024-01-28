class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        recursive(n,n,"");
        return res;
    }
    
    public void recursive(int left,int right,String str){
        if(left < 0 || right < 0 || left > right) return;
        if(left == 0 && right == 0) res.add(str);
        recursive(left-1,right,str+"(");
        recursive(left,right-1,str+")");
    }
}