class Solution {
    public int findMinMoves(int[] machines) {
        if(machines == null || machines.length == 0) return -1;
        int size = machines.length;
        int sum = 0;
        int leftSum = 0;
        int res = 0;
        for(int i=0;i<machines.length;i++){
            sum += machines[i];
        }
        if(sum % size != 0) return -1;
        int avg = sum / size;
        for(int i=0;i<size;i++){
            int leftRest = i * avg - leftSum;
            int rightRest = (size - i - 1) * avg - (sum - leftSum - machines[i]);
            if(leftRest > 0 && rightRest > 0){
                res = Math.max(res,Math.abs(leftRest) + Math.abs(rightRest));
            }else{
                res = Math.max(res,Math.max(Math.abs(leftRest),Math.abs(rightRest)));
            }
            leftSum += machines[i];
        }
        return res;
    }
}