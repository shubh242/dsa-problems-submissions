class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();

        // Checking the second element in the sum if present or not along with adding the element into the hashmap
        for(int i = 0; i < nums.length; i++){
            if(sumMap.containsKey(target-nums[i]))
                return new int[]{sumMap.get(target-nums[i]), i};
            else{
                sumMap.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
