class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        String[] strs = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length() == 0 || digits == null) return res;
        backtracing(digits,strs,0);
        return res;
    }
    
    public void backtracing(String digits,String[] strs,int num){
        if(num == digits.length()){
            res.add(sb.toString());
            return;
        }
        String str = strs[digits.charAt(num)-'0'];
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            backtracing(digits,strs,num+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}