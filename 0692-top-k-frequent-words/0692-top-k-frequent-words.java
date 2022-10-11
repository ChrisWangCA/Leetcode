class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            res.add(entry.getKey());
        }
        Collections.sort(res,new Comparator<String>(){
            public int compare(String s1,String s2){
                return map.get(s1) == map.get(s2) ?
                    s1.compareTo(s2) : map.get(s2) - map.get(s1);
            }
        });
        return res.subList(0,k);
    }
}