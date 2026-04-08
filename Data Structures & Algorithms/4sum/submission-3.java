class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for(int a = 0; a < n; a++) {
            if(a > 0 && nums[a] == nums[a-1]) continue;
            for(int b = a+1; b < n; b++) {
                if(b > (a+1) && nums[b] == nums[b-1]) continue;
                int c = b+1, d = nums.length-1;

                while(c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];

                    if(sum < target) {
                        c++;
                    } else if(sum > target){
                        d--;
                    } else if(sum == target) {
                        List<Integer> temp = Arrays.asList(new Integer[]{nums[a], nums[b], nums[c], nums[d]});
                        set.add(temp);
                        result.add(temp);
                        c++; d--;
                        while(c < d && nums[c] == nums[c-1]) c++;
                        while(c < d && nums[d] == nums[d+1]) d--;
                    }
                }
            }
        }

        return result;
    }
}