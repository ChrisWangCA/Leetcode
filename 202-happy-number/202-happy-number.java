class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    public int getNextNumber(int n){
        int res = 0;
        while(n > 0){
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}