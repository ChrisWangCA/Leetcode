class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        for(int i=0,j=str.length-1;i<j;i++,j--){
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
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