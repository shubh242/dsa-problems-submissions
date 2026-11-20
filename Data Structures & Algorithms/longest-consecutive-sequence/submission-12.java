class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(Integer num: set) {
            if(set.contains(num-1)) {
                continue;
            } else {
                int counter = 0;
                while(set.contains(num+counter)) {
                    counter++;
                }
                result = Math.max(result, counter);
            }
        }
        return result;
    }
}
