class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tempRes = new HashSet<>();
        Arrays.sort(nums);  // -4,-1,-1,0,1,2
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1, k = nums.length-1;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
                
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    tempRes.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return new ArrayList<>(tempRes); 
    }
}
