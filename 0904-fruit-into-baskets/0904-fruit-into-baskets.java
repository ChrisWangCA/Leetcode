class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int[] res = new int[fruits.length];
        int maxFruit = 0;
        int maxBasket = 0;
        for(int i=0;i<fruits.length;i++){
            int cur = fruits[i];
            if(res[cur] == 0) maxBasket++;
            res[cur] ++;
            while(maxBasket > 2){
                int leftFruit = fruits[left];
                res[leftFruit]--;
                if(res[leftFruit] == 0){
                    maxBasket--;
                }
                left++;
            }
            maxFruit = Math.max(maxFruit,i-left+1);
        }
        return maxFruit;
    }
}