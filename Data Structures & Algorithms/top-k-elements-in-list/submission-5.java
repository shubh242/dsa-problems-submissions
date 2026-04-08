class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1)
            return nums;

        // Creating a custom comparator for the pq sorting
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                return b.getValue() - a.getValue();
            }
        });
        Map<Integer, Integer> occMap = new HashMap<>();

        // Adding all the occurences into the map
        for(int i = 0; i < nums.length; i++){
            occMap.put(nums[i], occMap.getOrDefault(nums[i], 0)+1);
        }

        // Adding all the map entries into the priority queue
        pq.addAll(occMap.entrySet());

        int[] res = new int[k];
        while(k > 0){
            res[k-1] = pq.poll().getKey();
            k--;
        }
        return res;
    }
}
