class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String newString = new String(chs);
            if(map.containsKey(newString)){
                map.get(newString).add(s);
            }else{
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(newString,group);
            }
        }
        return new ArrayList<>(map.values());
    }
}