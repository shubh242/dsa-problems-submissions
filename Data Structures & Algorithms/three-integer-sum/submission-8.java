class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> dups = new HashSet<>();
        
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
                    List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                    if(!dups.contains(temp)) {
                        dups.add(temp);
                        res.add(temp);
                    }
                    j++; k--;
                }
            }
        }
        return res;
    }
}
