class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        int right = str.length-1;
        for(int i=0;i<right;i++){
            String temp = str[i];
            str[i] = str[right];
            str[right] = temp;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(!str[i].equals("")){
                if(i == str.length-1){
                    sb.append(str[i]);
                }else{
                    sb.append(str[i]).append(" ");
                }
            }
        }
        return sb.toString();
    }
}