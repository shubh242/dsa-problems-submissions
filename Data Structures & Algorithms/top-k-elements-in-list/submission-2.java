class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] res = new int[k];
        
        for(int i = 0; i < nums.length; i++){
            if(!numsMap.containsKey(nums[i])){
                numsMap.put(nums[i], 1);
            }else{
                numsMap.put(nums[i], numsMap.get(nums[i])+1);
            }
        }

        for(int i = 0; i < k; i++){
            int maxi = nums[0];
            int maxCount = Integer.MIN_VALUE;
            for(int j = 0; j < nums.length; j++){
                if(numsMap.containsKey(nums[j])){
                    if(maxCount < numsMap.get(nums[j])){
                        maxi = nums[j];
                        maxCount = numsMap.get(nums[j]);
                    }
                }
            }
            
            res[i] = maxi;
            numsMap.remove(maxi);
        }

        return res;
    }
}
