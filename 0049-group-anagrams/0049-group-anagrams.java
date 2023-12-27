class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s1 = new String(chs);
            if(map.containsKey(s1)){
                map.get(s1).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s1,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}