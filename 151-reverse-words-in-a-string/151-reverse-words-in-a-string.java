class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        int right = arr.length-1;
        for(int i=0;i<right;i++){
            String temp = arr[i];
            arr[i] = arr[right];
            arr[right] = temp;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                if(i == arr.length-1){
                    sb.append(arr[i]);
                }else{
                    sb.append(arr[i] + " ");
                }
            }
        }
        return sb.toString();
    }
}