class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] str = s.split(" ");
        for(int i=0,j=str.length-1;i<j;i++,j--){
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        for(int i=0;i<str.length;i++){
            if(!str[i].equals("")){
                if(i!=str.length-1){
                    sb.append(str[i]).append(" ");
                }else{
                    sb.append(str[i]);
                }
            }
        }
        return sb.toString();
    }
}