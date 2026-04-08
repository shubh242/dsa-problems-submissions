 class MyHashSet {
    private int[] set;
    public MyHashSet() {
        set = new int[1000000];
    }
    
    public void add(int key) {
        this.set[key] = key;
    }
    
    public void remove(int key) {
        this.set[key] = -1;
    }
    
    public boolean contains(int key) {
        return this.set[key] > 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */