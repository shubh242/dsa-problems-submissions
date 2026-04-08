// import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(numsMap.containsKey(target - nums[i]))
                return new int[]{numsMap.get(target-nums[i]), i};
            else
                numsMap.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
