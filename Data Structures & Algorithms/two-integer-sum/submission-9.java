// import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int idx=0;

        for(int i = 0; i < nums.length; i++){
            numsMap.put(nums[i], i);
        }

        int i = 0;
        while(i < nums.length){
            
            if(numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])){
                idx = numsMap.get(target - nums[i]);
                return new int[]{Math.min(idx, i), Math.max(idx, i)};
            }
            i++;
        }
        return new int[]{-1,-1};
    }
}
