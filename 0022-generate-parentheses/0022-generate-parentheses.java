class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(res,n,n,"");
        return res;
    }
    public void recursive(List<String> res,int left,int right,String str){
        if(left < 0 || right < 0 || left > right) return;
        if(left == 0 && right == 0){
            res.add(str);
        }
        recursive(res,left-1,right,str+"(");
        recursive(res,left,right-1,str+")");
    }
}