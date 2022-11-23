class RandomizedSet {

    HashMap<Integer,Integer> keyToIndex;
    HashMap<Integer,Integer> indexToKey;
    int size;
    public RandomizedSet() {
        keyToIndex = new HashMap<>();
        indexToKey = new HashMap<>();
        size = 0;
    }
    
    public boolean insert(int val) {
        if(!keyToIndex.containsKey(val)){
            keyToIndex.put(val,size);
            indexToKey.put(size++,val);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(keyToIndex.containsKey(val)){
            int lastIndex = --size;
            int lastKey = indexToKey.get(lastIndex);
            int deleteIndex = keyToIndex.get(val);
            keyToIndex.put(lastKey,deleteIndex);
            indexToKey.put(deleteIndex,lastKey);
            keyToIndex.remove(val);
            indexToKey.remove(lastIndex);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int random = (int)(Math.random() * size);
        return indexToKey.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */