class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;

            if( i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            // -4,-1,-1,0,1,2

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    set.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
