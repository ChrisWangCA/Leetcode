class RandomizedSet {
    
    HashMap<Integer,Integer> keyIndexMap;
    HashMap<Integer,Integer> indexKeyMap;
    int size;
    
    public RandomizedSet() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0; 
    }
    
    public boolean insert(int val) {
        if(!keyIndexMap.containsKey(val)){
            keyIndexMap.put(val,size);
            indexKeyMap.put(size++,val);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(keyIndexMap.containsKey(val)){
            int lastIndex = --size;
            int lastKey = indexKeyMap.get(lastIndex);
            int deleteIndex = keyIndexMap.get(val);
            keyIndexMap.put(lastKey,deleteIndex);
            indexKeyMap.put(deleteIndex,lastKey);
            keyIndexMap.remove(val);
            indexKeyMap.remove(lastIndex);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        if(size == 0) return 0;
        int randomIndex = (int)(Math.random() * size);
        return indexKeyMap.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */