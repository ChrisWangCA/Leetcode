class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruit = 0;
        int maxBasket = 0;
        int left = 0;
        int[] res = new int[fruits.length];
        for(int i=0;i<fruits.length;i++){
            int curFruit = fruits[i];
            if(res[curFruit] == 0) maxBasket++;
            res[curFruit]++;
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