class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] cur = new int[26];
            StringBuilder sb = new StringBuilder();
            for(char c:str.toCharArray()){
                cur[c - 'a']++;
            }
            for(int i=0;i<26;i++){
                if(cur[i] == 0) continue;
                sb.append((char)('a' + i)).append(cur[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for(List<String> group:map.values()){
            res.add(group);
        }
        return res;
    }
}