class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null) return res;
        String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracing(digits,str,0);
        return res;
    }
    
    public void backtracing(String digits,String[] str,int num){
        if(num == digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = str[digits.charAt(num)-'0'];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtracing(digits,str,num+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}