class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> nMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            nMap.put(nums[i], nMap.getOrDefault(nums[i], 0) + 1);

            if(nMap.get(nums[i]) > nums.length / 2) 
                return nums[i];
        }

        return 0;
    }
}