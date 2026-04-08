class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                pq.add(new int[]{nums[i], map.get(nums[i])});
                map.remove(nums[i]);
            }
        }

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
