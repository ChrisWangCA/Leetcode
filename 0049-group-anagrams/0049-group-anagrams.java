class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                List<String> group = new ArrayList<>();
                group.add(str);
                map.put(s,group);
            }
        }
        return new ArrayList<>(map.values());
    }
}