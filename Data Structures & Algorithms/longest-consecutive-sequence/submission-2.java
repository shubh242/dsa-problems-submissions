class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int con = Integer.MIN_VALUE;
        int counter = 0;
        Set<Integer> numSet = new HashSet<>();

        for(int i = 0; i < n; i++){
            numSet.add(nums[i]);
        }

        Object[] numArr = numSet.toArray();
        for(int i = 0; i < numSet.size(); i++){
            if(!numSet.contains((Integer) numArr[i] - 1)){
                while(numSet.contains((Integer)numArr[i] + counter)){
                    counter++;
                }
                con = Math.max(con, counter);
                counter = 0;
            }
        }
        return con;
    }
}
