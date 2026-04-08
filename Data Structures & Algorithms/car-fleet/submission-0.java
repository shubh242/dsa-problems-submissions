class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Float> sortedPlaces = new TreeMap<>();

        for(int i = 0; i < position.length; i++){
            float temp = (float) (target-position[i])/speed[i];
            sortedPlaces.put((target-position[i]), temp);
        }

        float maxVal = Float.MIN_VALUE;
        int count = 0;
        for(Integer key: sortedPlaces.keySet()){
            if(maxVal >= sortedPlaces.get(key)){
                continue;
            }else{
                count++;
                maxVal = sortedPlaces.get(key);
            }
        }
        System.out.println(sortedPlaces.toString());
        return count;
    }
}
