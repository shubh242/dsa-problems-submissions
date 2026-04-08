class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 1; int j = nums.length;
        int[] res = new int[j];
        int[] res1 = new int[j];
        int[] res2 = new int[j];
        res1[0] = 1;
        res2[j-1] = 1;
        while(i < j){
            res1[i] = res1[i-1]*nums[i-1];
            i++;
        }
        i = 0;
        j = j-2;

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
