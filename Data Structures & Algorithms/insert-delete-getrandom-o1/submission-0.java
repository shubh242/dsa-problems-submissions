class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    int counter;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        counter = 0;
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, counter++);
        list.add(val);
        return true;
    }
    
    // {1:0, 2:1, } [1,2]
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index = map.get(val);
        int tmpVal = list.get(list.size()-1);
        list.set(index, tmpVal);
        map.put(tmpVal, index);
        map.remove(val);
        list.remove(list.size()-1);
        counter--;
        return true;
    }
    
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */