package src.greedy;

import java.util.PriorityQueue;

public class SplitGold {

    public int splitGold(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (heap.size()>1){
            cur = heap.poll() + heap.poll();
            sum += cur;
            heap.add(cur);
        }
        return sum;
    }
}
