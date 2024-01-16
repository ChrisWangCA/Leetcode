class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String newString = new String(chs);
            if(map.containsKey(newString)){
                map.get(newString).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(newString,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}