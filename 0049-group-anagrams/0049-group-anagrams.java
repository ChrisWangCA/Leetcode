class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sortedString = new String(chs);
            if(groups.containsKey(sortedString)){
                groups.get(sortedString).add(str);
            }else{
                List<String> group = new ArrayList<>();
                group.add(str);
                groups.put(sortedString,group);
            }
        }
        return new ArrayList<>(groups.values());
    }
}