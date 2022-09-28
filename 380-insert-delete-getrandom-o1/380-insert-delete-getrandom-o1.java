class RandomizedSet {
    HashMap<Integer,Integer> KeyToIndex;
    HashMap<Integer,Integer> IndexToKey;
    int size;
    public RandomizedSet() {
        KeyToIndex = new HashMap<>();
        IndexToKey = new HashMap<>();
        this.size=0;
    }
    
    public boolean insert(int val) {
        if(!KeyToIndex.containsKey(val)){
            KeyToIndex.put(val,size);
            IndexToKey.put(size++,val);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(KeyToIndex.containsKey(val)){
            int lastIndex = -- size;
            int lastKey = IndexToKey.get(lastIndex);
            int deleteIndex = KeyToIndex.get(val);
            KeyToIndex.put(lastKey,deleteIndex);
            IndexToKey.put(deleteIndex,lastKey);
            KeyToIndex.remove(val);
            IndexToKey.remove(lastIndex);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        if(size == 0) return 0;
        int random = (int)(Math.random() * size);
        return IndexToKey.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */