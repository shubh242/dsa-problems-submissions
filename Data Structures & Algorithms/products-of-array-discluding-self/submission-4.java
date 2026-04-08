class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int i = 1; int j = nums.length;
        int[] res = new int[nums.length];
        int[] res1 = new int[nums.length];
        res1[0] = 1;
        int[] res2 = new int[nums.length];
        res2[res2.length-1] = 1;
        while(i < j){
            res1[i] = res1[i-1]*nums[i-1];
            i++;
        }
        i = 0;
        j = nums.length-2;

        while(i <= j){
            res2[j] = res2[j+1] * nums[j+1];
            j--;
        }

        for(int idx = 0; idx < nums.length; idx++){
            res[idx] = res1[idx] * res2[idx];
        }
            
        return res;
    }
}  
