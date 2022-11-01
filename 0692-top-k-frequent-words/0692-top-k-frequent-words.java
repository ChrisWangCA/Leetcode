class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            res.add(entry.getKey());
        }
        Collections.sort(res,new Comparator<String>(){
            public int compare(String o1,String o2){
                return map.get(o1) == map.get(o2) ? o1.compareTo(o2):
                map.get(o2) - map.get(o1);
            }
        });
        return res.subList(0,k);
    }
}