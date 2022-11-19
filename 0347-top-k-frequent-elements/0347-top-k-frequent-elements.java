class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Map.Entry<Integer,Integer>> sets = map.entrySet();
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
        (o1,o2)->o2.getValue() - o1.getValue());
        for(Map.Entry<Integer,Integer> set:sets){
            queue.offer(set);
        }
        for(int i=k-1;i>=0;i--){
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}