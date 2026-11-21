class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
                if(i == j) {
                    j++;
                    continue;
                } else if(i == k) {
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
