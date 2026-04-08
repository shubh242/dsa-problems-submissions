class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] freq = new int[nums.length];
        int[] res = new int[k];
        
        for(int i = 0; i < nums.length; i++){
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> result = new PriorityQueue<>(
            (a,b) -> b.getValue().compareTo(a.getValue())
        );

        result.addAll(numsMap.entrySet());

        // System.out.println(result.toString());

        while(k > 0){
            Map.Entry<Integer, Integer> tempEntry = result.poll();
            res[k-1] = tempEntry.getKey();
            k--;
        }

        return res;
    }
}
