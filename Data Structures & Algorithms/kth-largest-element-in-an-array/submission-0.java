class Solution {
    public int findKthLargest(int[] nums, int k) {
        int maxEle = 0;
        for(int j = 0; j < k; j++){
            maxEle = Integer.MIN_VALUE;
            int idx = -1;
            for(int i = 0; i < nums.length; i++){
                if(maxEle < nums[i]){
                    maxEle = nums[i];
                    idx = i;
                }
            }
            nums[idx] = Integer.MIN_VALUE;
        }
        return maxEle;
    }
}
