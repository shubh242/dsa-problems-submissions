class MyHashMap {

    private int[] key;
    private int[] value;

    public MyHashMap() {
        this.key = new int[1000001];
        this.value = new int[1000001];
        Arrays.fill(this.key, -1);
        Arrays.fill(this.value, -1);
    }
    
    public void put(int key, int value) {
        this.key[key] = key;
        this.value[key] = value;
    }
    
    public int get(int key) {
        if(this.value[key] != -1) return this.value[key];

        return -1;
    }
    
    public void remove(int key) {
        this.key[key] = -1;
        this.value[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */