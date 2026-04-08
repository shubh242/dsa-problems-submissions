class TimeMap {

    int[] timestamp = new int[100];
    Map<Integer, String[]> timeMap = new HashMap<>();
    int counter = 0;
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        this.timestamp[counter] = timestamp;
        timeMap.put(timestamp, new String[]{key, value});
        this.counter++;
    }
    
    public String get(String key, int timestamp) {

        if(this.timeMap.containsKey(timestamp) && this.timeMap.get(timestamp)[0].equals(key)){
            return this.timeMap.get(timestamp)[1];
        }

        int i = -1;
        int low = 0;
        int high = this.counter;
        int mid = (high+low)/2;

        System.out.println("COUNTER " + this.counter);

        while(low <= high){
            System.out.println(low + " " + mid + " " + high);
            if(this.timestamp[mid] <= timestamp){
                i = mid;
                // break;
            }

            if(this.timestamp[mid] > timestamp){
                high = mid-1;
            }else{
                low = mid+1;
            }
            mid = (high+low)/2;
        }
        
        i = (i < 0) ? mid-1 : i;

        // System.out.println(Arrays.toString(this.timestamp));
        while(i >= 0){
            if(this.timeMap.containsKey(this.timestamp[i]) && this.timeMap.get(this.timestamp[i])[0].equals(key))
                return this.timeMap.get(this.timestamp[i])[1];
            i--;
        }
        return "";    
    }
}
