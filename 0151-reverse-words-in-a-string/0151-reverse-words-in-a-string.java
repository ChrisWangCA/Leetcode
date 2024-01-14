class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] chs = s.split(" ");
        for(int i=0,j=chs.length-1;i<j;i++,j--){
            String temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chs.length;i++){
            if(!chs[i].equals("")){
                if(i != chs.length-1){
                    sb.append(chs[i]).append(" ");
                }else{
                    sb.append(chs[i]);
                }
            }
        }
        return sb.toString();
    }
}