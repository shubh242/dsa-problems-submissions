class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            prod = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j)
                    prod *= nums[j];
            }
            res[i] = prod;
        }
        return res;
    }
}  
