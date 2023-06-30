class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> maps = new HashMap<>();
        
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sortedString = new String(chs);
            if(maps.containsKey(sortedString)){
                maps.get(sortedString).add(str);
            }else{
                List<String> map = new ArrayList<>();
                map.add(str);
                maps.put(sortedString,map);
            }
        }
        return new ArrayList<>(maps.values());
    }
}