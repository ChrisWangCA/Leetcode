class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        String[] strs = {"",
                        "",
                        "abc",
                        "def",
                        "ghi",
                        "jkl",
                        "mno",
                        "pqrs",
                        "tuv",
                        "wxyz"};
        backtracing(digits,strs,0);
        return res;
    }
    
    public void backtracing(String digits, String[] strs, int nums){
        if(nums == digits.length()){
            res.add(sb.toString());
            return;
        }
        String str = strs[digits.charAt(nums)-'0'];
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            backtracing(digits,strs,nums+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}