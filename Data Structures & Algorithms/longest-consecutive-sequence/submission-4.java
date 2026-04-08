class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> tracker = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            tracker.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if(!tracker.contains(nums[i]-1)){
                int longest = 1;
                while(tracker.contains(nums[i] + longest)){
                    longest++;
                }
                maxLen = Math.max(maxLen, longest);
            }
        }
        return maxLen;
    }
}
