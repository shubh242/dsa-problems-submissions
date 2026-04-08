class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> dups = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    if(!dups.contains(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}))) {
                        dups.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}));
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}));
                    }
                    j++; k--;
                }
            }
        }
        return result;
    }
}
