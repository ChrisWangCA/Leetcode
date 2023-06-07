class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String,Integer> key:map.entrySet()){
            res.add(key.getKey());
        }
        Collections.sort(res,new Comparator<String>(){
            public int compare(String o1,String o2){
                return map.get(o1) == map.get(o2) ?
                    o1.compareTo(o2) : map.get(o2) - map.get(o1);
            }
        });
        return res.subList(0,k);
    }
}