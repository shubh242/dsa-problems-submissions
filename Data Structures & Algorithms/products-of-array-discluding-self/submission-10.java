class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int product = 1;

        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            arr[i] = product;
        }

        product = 1;
        int[] suffix = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
            product *= nums[i];
            suffix[i] = product;
        }

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                res[i] = suffix[i+1];
            } else if(i == nums.length-1) {
                res[i] = arr[i-1];
            } else {
                res[i] = arr[i-1] * suffix[i+1];
            }
        }

        return res;
    }
}  
