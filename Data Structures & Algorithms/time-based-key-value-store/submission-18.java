class TimeMap {

    int counter;
    int[] timestampArr;
    HashMap<Integer, String[]> map;
    public TimeMap() {
        timestampArr = new int[200000];
        counter = 0;
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timestampArr[counter++] = timestamp;
        this.map.put(timestamp, new String[]{key, value});
    }
    
    public String get(String key, int timestamp) {
        if(this.map.containsKey(timestamp) && this.map.get(timestamp)[0].equals(key)) {
            return this.map.get(timestamp)[1];
        }

        int low = 0;
        int high = counter;
        int i = -1;
        int mid = (low+high)/2;

        while(low <= high) {
            mid = (low+high)/2;

            if(timestampArr[mid] <= timestamp) {
                i = mid;
                // break;
            }
            
            if(timestampArr[mid] > timestamp) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        i = i < 0 ? mid-1: i;

        while(i >= 0) {
            if(this.map.containsKey(timestampArr[i]) && this.map.get(timestampArr[i])[0].equals(key)) {
                return this.map.get(timestampArr[i])[1];
            }
            i--;
        }
        return "";
    }
}
