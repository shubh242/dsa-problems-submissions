class TimeMap {

    String[] key = new String[1001];
    String[] value = new String[1001];
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        this.key[timestamp] = key;
        this.value[timestamp] = value;
    }
    
    public String get(String key, int timestamp) {

        // System.out.println(timestamp + " " + this.key.length);
        if(timestamp < this.key.length){
            if(this.key[timestamp] != null && this.key[timestamp].equals(key))
                return this.value[timestamp];
        }

        int i = (timestamp >= this.key.length) ? this.key.length-1 : timestamp-1;
        
        while(i > 0){
            if(this.key[i] != null && this.key[i].equals(key))
                return this.value[i];
            i--;
        }

        return "";
    }
}
