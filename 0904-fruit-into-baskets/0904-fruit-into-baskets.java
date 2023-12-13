class Solution {
    public int totalFruit(int[] fruits) {
        int maxBasket = 0;
        int maxFruit = 0;
        int left = 0;
        int[] res = new int[fruits.length];
        for(int i=0;i<fruits.length;i++){
            int cur = fruits[i];
            if(res[cur] == 0){
                maxBasket++;
            }
            res[cur]++;
            while(maxBasket > 2){
                int leftFruit = fruits[left];
                res[leftFruit]--;
                if(res[leftFruit] == 0){
                    maxBasket--;
                }
                left++;
            }
            maxFruit = Math.max(i - left + 1, maxFruit);
        }
        return maxFruit;
    }
}