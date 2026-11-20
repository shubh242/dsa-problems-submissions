class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Map.Entry<Integer, Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        res.addAll(map.entrySet());

        res.sort((a,b) -> b.getValue() - a.getValue());
        
        for(int i = 0; i < result.length; i++) {
            result[i] = res.get(i).getKey();
        }
        return result;
    }
}
