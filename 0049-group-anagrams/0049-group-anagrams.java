class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sorted = new String(chs);
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}