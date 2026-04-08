class Solution {
    public int[] sortArray(int[] nums) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int counter = 0;

        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        for(int i = min; i <= max; i++) {
            if(numsMap.containsKey(i)) {
                for(int j = 0; j < numsMap.get(i); j++) {
                    nums[counter++] = i;
                }
            }
        }

        return nums;
    }
}